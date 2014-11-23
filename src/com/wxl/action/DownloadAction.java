package com.wxl.action;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

public class DownloadAction {
	private String fileName;
	
	
	

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName){
		this.fileName = fileName;
	}
	
	/*public InputStream getDownloadFile(){
		 String newFileName=null;
    try {
		newFileName =  new String(fileName.getBytes("iso-8859-1"),"UTF-8");
	} catch (UnsupportedEncodingException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    String url = ServletActionContext.getServletContext().getRealPath("/")+"files/"+newFileName;
    
    File f = new File(url);
    
    FileInputStream fin=null;
	try {
		fin = new FileInputStream(f);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    System.out.println(url);
    return fin;
	}*/
	public InputStream getDownloadFile() {
		String newFileName="";
		if(fileName!=""&&fileName!=null){
		try {
			newFileName = new String(fileName.getBytes("iso-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		return ServletActionContext.getServletContext().getResourceAsStream(
			     "/files/" + newFileName); 
		
	}
	public String execute(){
		return "success";
	}
}
