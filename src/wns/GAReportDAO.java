package wns;

import java.util.ArrayList;
import java.util.List;

public class GAReportDAO {
	public static List<String> getRequestorList() {
		//System.out.println("wns.GAReportDAO.getRequestorList()");
        List<String> list = new ArrayList<String>();
        list.add("a@wns.com");
        list.add("ab@wns.com");
        list.add("abc@wns.com");
        list.add("abcd@wns.com");
        return list;
	}
	
	public static String toJavascriptArray(String[] arr) {
		//System.out.println("wns.GAReportDAO.toJavascriptArray()");
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append("\"").append(arr[i]).append("\"");
            if (i + 1 < arr.length) {
                sb.append(",");
            }
        }
        sb.append("]");
        //System.out.println(sb);
        return sb.toString();
    }
}
