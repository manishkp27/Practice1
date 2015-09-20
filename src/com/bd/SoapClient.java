package com.bd;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.IOException;  
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Iterator;
  
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.AttachmentPart;
import javax.xml.soap.MessageFactory;  
import javax.xml.soap.MimeHeader;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;  
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;  
import javax.xml.soap.SOAPPart;  
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;


public class SoapClient {

	
	
	
	public SOAPMessage readSoapMessage(String filename) throws SOAPException,  
	    FileNotFoundException {  
		SOAPMessage message = MessageFactory.newInstance().createMessage();  
		SOAPPart soapPart = message.getSOAPPart();  
		soapPart.setContent(new StreamSource(new FileInputStream(filename)));  
		message.saveChanges();  
		return message;  
	}  

	public static void main(String[] args) 
	{
		
		String filename="D:/EclipseWorkSpace/testing/src/com/bd/soapmessage.xml";  
	    SOAPMessage message;
		try {
			message= new SoapClient().readSoapMessage(filename);  
	        //message.writeTo(System.out);  
	        
	        // Create SOAP Connection
	        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
	        SOAPConnection soapConnection = soapConnectionFactory.createConnection();

	        // Send SOAP Message to SOAP Server
	       // String url = "http://ws.cdyne.com/emailverify/Emailvernotestemail.asmx";
	        SOAPMessage soapResponse = soapConnection.call(message,"http://www.bounzd.com/index/soap");

	        // print SOAP Response
	        System.out.print("Response SOAP Message:");
	        soapResponse.writeTo(System.out);
	        //converttoBeans1(soapResponse);
	        
	        //ByteArrayOutputStream out = new ByteArrayOutputStream();  
			//soapResponse.writeTo(out); 
			//System.out.println(out.toString());
			//PrintWriter pwriter = new PrintWriter("soapResponse.txt");
			//pwriter.print(System.out);
			
	        //func1(soapResponse);
	        
	        
	        soapConnection.close();
	        
	        
		} catch (SOAPException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static Iterator<MimeHeader> allHeaders;

	private static void decode(SOAPMessage soapResponse)
	{
		allHeaders = soapResponse.getMimeHeaders().getAllHeaders();
		String name,value;
		while(allHeaders.hasNext())
		{
			
			name = allHeaders.next().getName();
			value = allHeaders.next().getValue();
		}
	}
	private static void func1(SOAPMessage soapResponse)
	{
		try{
		    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		    documentBuilderFactory.setNamespaceAware(true);
		    DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
		    Document doc = builder.parse("D:/EclipseWorkSpace/testing/src/com/bd/soapResponse.txt");

		    XPathFactory xPathFactory = XPathFactory.newInstance();
		    XPath xpath = xPathFactory.newXPath();

		    XPathExpression expression = xpath.compile("/SOAP-ENV:Envelope/SOAP-ENV:Body/ns1:getCallDetailsResponse[return xsi:type=ns2:Map]/*");

		    NodeList nodes = (NodeList) expression.evaluate(doc, XPathConstants.NODESET);

		    for(int i = 0;i<nodes.getLength();i++){
		        System.out.println(nodes.item(i).getNodeName());
		        System.out.println(nodes.item(i).getTextContent());
		    }
		} catch(Exception exception){
		    exception.printStackTrace();
		}
	}
	
	/*private static void converttoBeans1( SOAPMessage soapResponse) throws Exception {
		
		SOAPPart sPort = soapResponse.getMimeHeaders().getAllHeaders() getSOAPPart();
		NodeList elementsByTagName = sPort.getTextContent() getElementsByTagName("getCallDetailsResponse");
		System.out.println(elementsByTagName.toString());
		
		SOAPEnvelope sEnv = sPort.getEnvelope();
		SOAPBody soapBody = sEnv.getBody();
		SOAPHeader soapHead = sEnv.getHeader();
		System.out.println(soapHead.toString());
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();  
		soapResponse.writeTo(out); 
		System.out.println(out.toString());
		
		
		
		MessageFactory factory = MessageFactory.newInstance();
	    SOAPMessage message = factory.createMessage(
	            new MimeHeaders(),
	            new ByteArrayInputStream(out.toString().getBytes(Charset
	                    .forName("UTF-8"))));

	    SOAPBody body = message.getSOAPBody();

	    NodeList returnList = body.getElementsByTagName("ns1:getCallDetailsResponse");
		
		System.out.println(returnList);
		
		SOAPHeader body =  soapResponse.getSOAPHeader();//getSOAPBody();
		Iterator iterator = body.getChildElements();
		while(iterator.hasNext())
		{
			SOAPBodyElement  ap = (SOAPBodyElement ) iterator.next();

	            //Get content type
	            String contentType = ap.getContentType();
	            System.out.println("content type: " + contentType);

	            //Get content id
	            String contentId = ap.getValue();
	            System.out.println("content Id:" + contentId);
	    
	            //Check to see if this is text    
	            if(contentType.indexOf("text")>=0) {
	                //Get and print string content if it is a text attachment
	                String content = (String) ap.getContent();
	                System.out.println("*** attachment content: " + content);
	            }
		}
	}*/
	
	private static void converttoBeans( SOAPMessage soapResponse) throws Exception {
		Iterator iterator =  soapResponse.getAttachments();
		while(iterator.hasNext())
		{
			 AttachmentPart ap = (AttachmentPart) iterator.next();

	            //Get content type
	            String contentType = ap.getContentType();
	            System.out.println("content type: " + contentType);

	            //Get content id
	            String contentId = ap.getContentId();
	            System.out.println("content Id:" + contentId);
	    
	            //Check to see if this is text    
	            if(contentType.indexOf("text")>=0) {
	                //Get and print string content if it is a text attachment
	                String content = (String) ap.getContent();
	                System.out.println("*** attachment content: " + content);
	            }
		}
	}
}
