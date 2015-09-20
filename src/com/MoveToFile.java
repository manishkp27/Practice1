package com;

import java.io.File;
import java.util.Date;

public class MoveToFile {
	static Commonlog commonlog=new Commonlog();
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		myFileMoveTest();
	}
	static boolean myFileMoveTest(){
		try{
			boolean bFileMoved=false;
			File sFile= new File("D:/TransA/srcFolder/NPSH15080301.pdf"), fTemp=new File("D:/TransA/srcFolder/backup/NPSH15080301.pdf");
			
			do{					
				if(!bFileMoved)
					bFileMoved=sFile.renameTo(fTemp);

				if(bFileMoved)
				{	commonlog.error(sFile+" moved to "+fTemp);
				}
				else
				{	commonlog.error("Error in moving file "+sFile+" to "+fTemp);
					
					// check file already moved from source and exists at destination
					System.out.println("sFile="+sFile.exists()+" fTemp="+fTemp.exists());
					if(sFile.exists()==false && fTemp.exists()==true){
						return false;
					}
				}
			}while(!bFileMoved);
		}
    	catch(Exception e){
    		commonlog.error("Error in moving file ");
    		return false;
    	}
		return false;
	}
	
	static public boolean moveToFolder(String sPath,String sBackUpFolderName,String sDateFolder,String sImageName,String sMoveFolderName,File sFile)
    {
    	//Added by Deepak on 22July2013......SDP:3581915
    	String sBackUpFolderNametemp=sBackUpFolderName;
    	String sPathtemp=sPath;
    	String sImageNametemp=sImageName;
    	/*commonlog.info("Deepak Gupta sBackUpFolderNametemp==="+sBackUpFolderNametemp);
    	commonlog.info("Deepak Gupta sPathtemp==="+sPathtemp);
    	commonlog.info("Deepak Gupta sImageNametemp==="+sImageNametemp);
    	commonlog.info("Deepak Gupta sMoveFolderName===="+sMoveFolderName);*/
    	//Changes ends here....Added by Deepak on 22July2013......SDP:3581915
    	boolean bFileMoved=false;
    	try
    	{
    		sPath = sPath + File.separator+sImageName;
    		if(sMoveFolderName.equals("Duplicate")){
    		sImageName=sImageName.substring(0,sImageName.indexOf('.'))+"_"+new Date().getTime()+sImageName.substring(sImageName.indexOf('.'));
    		//System.out.println("sImageName"+sImageName);
    		}
    		
//    		Creating the Date Folder inside the backup folder/(success/unsuccess)	
    		File fTemp = new File(sBackUpFolderName +  System.getProperty("file.separator") + sMoveFolderName + System.getProperty("file.separator") + sDateFolder);
        	if(fTemp == null || !fTemp.isDirectory())
        		fTemp.mkdir();
    		
    		sBackUpFolderName = sBackUpFolderName + File.separator+sMoveFolderName+File.separator+sDateFolder+File.separator+sImageName;
    		//sBackUpFolderName = sBackUpFolderName + File.separator+sMoveFolderName+File.separator+sImageName.substring(0,sImageName.indexOf('.'))+"_"+new Date().getTime()+sImageName.substring(sImageName.indexOf('.'));
    		//sImageName.substring(0,sImageName.indexOf('.')))+"_"+new Date().getTime()+".xls"
    		//sImageName.substring(0,sImageName.indexOf('.')))+"_"+new Date().getTime()+sImageName.substring(sImageName.indexOf('.')))
    		//System.out.println("Inside Move file :::::::::::::::::: "+sBackUpFolderName);
    		
    		//System.out.println("*********tracing "+sBackUpFolderName);
    		fTemp =null;
    		fTemp= new File(sBackUpFolderName);
    		
        	//Added by Deepak on 22July2013......SDP:3581915
    		//only if file is for Japan and already exists on backup(success/unsuccess) folder
    		System.out.println("*********tracing "+sPathtemp);
    	/*	if((!sMoveFolderName.equals("Duplicate")) && sPathtemp.toUpperCase().contains("SCAN/JAPAN") || sPathtemp.toUpperCase().contains("SCAN/EMIJAPAN") && fTemp.exists()){
    			commonlog.info(sImageNametemp+" is duplicate file for Japan, and already exists in backup folder "+sBackUpFolderNametemp+"/"+sMoveFolderName+"/"+sDateFolder+", hence renaming this images and adding datetime stamp.");
    			//adding the datetime stamp to image
    			sImageName=sImageNametemp.substring(0,sImageNametemp.indexOf('.'))+"_"+new Date().getTime()+sImageNametemp.substring(sImageNametemp.indexOf('.'));
    			//Renaming the existing image on the pickup path with new image name.
    			String sImagePathtemp = sPathtemp + File.separator+sImageName;
    			commonlog.info("File renaming to ::::"+sImagePathtemp);
    			File frename=new File(sImagePathtemp);
    			boolean japanduplicate =sFile.renameTo(frename);
    			commonlog.info("File renamed status::::"+japanduplicate);
    			//updating the object received while method call
    			sFile=new File(sImagePathtemp);
    			
    			//Creating the new backup path with updated image name
    			sBackUpFolderName=sBackUpFolderNametemp+System.getProperty("file.separator") + sMoveFolderName + System.getProperty("file.separator") + sDateFolder+File.separator+sImageName;
    			commonlog.info("New Backup path is ::::"+sBackUpFolderName);
    			//updating the fTemp object with new backup path file object
    			fTemp=new File(sBackUpFolderName);
    			
    			
    			  
    		}*/
        	//Changes ends here....Added by Deepak on 22July2013......SDP:3581915
    		
    		do{	
    			if(!bFileMoved)
    				bFileMoved=sFile.renameTo(fTemp);

    			if(bFileMoved)
    				commonlog.error(sFile+" moved to "+fTemp);
    			else
    				commonlog.error("Error in moving file "+sFile+" to "+fTemp);
    		}while(!bFileMoved);
    	}
    	catch(Exception e){
    		commonlog.error("Error in moving file "+sFile+" to the specified folder...."+e.toString());
    		return false;
    	}

    	return true;
    }
}
class Commonlog{

	void error(String s){
		System.out.println(s);
		}
	void info(String s){System.out.println(s);}
}
