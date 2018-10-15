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
}
