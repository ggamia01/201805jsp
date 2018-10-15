package kr.or.ddit.util.model;

public class StringUtil {
	/** 
	 * Method : getFileNameFromHeader
	 * 작성자 : ASUS
	 * 변경이력 : 
	 * @param contentDisposition
	 * @return 
	 * Method 설명 : contentDisposition에서 filename추출
	 */
	public static String getFileNameFormHeader(String contentDisposition){

		String fileName = "";
		String[] splits = contentDisposition.split("; ");
		for(String str : splits){
			if(str.indexOf("filename=")>=0){
				fileName = str.substring(10,str.lastIndexOf("\""));
			}
		}
		
		return fileName;
	}

	public static String getCookie(String cookieString, String string) {
		
		String getCookieValue = "";
		String[] splits = cookieString.split("; ");
		for(String str : splits){
			if(str.startsWith(string +"=")){
				getCookieValue = str.substring((string + "=").length());
			}
		}
		
		return getCookieValue;
	}
}
