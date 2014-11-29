package com.wxl.action;

import java.text.ParseException;
import java.util.ArrayList;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import com.wxl.dao.TeacherDao;

public class TeacherAction extends BaseAction{
	TeacherDao td = new TeacherDao();
	String data;
	String class_;
	String date;
	String s_jie;
	
	public String getClass_() {
		return class_;
	}


	public void setClass_(String class1) {
		class_ = class1;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getS_jie() {
		return s_jie;
	}


	public void setS_jie(String sJie) {
		s_jie = sJie;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}

	/**
	 * 获得所有班级的Action方法
	 * @return
	 */
	public String getAllClass(){
		ArrayList al = td.getAllClass();
		JSONArray jsonarr = JSONArray.fromObject(al);
		data = jsonarr.toString();
		return "getAllClass";
	}
	public String queryAllSignin(){
		try {
			data=null;
			ArrayList al = td.getSigninStudent(class_, date, s_jie);
			
			JsonConfig jsonConfig = new JsonConfig();  //建立配置文件
			//jsonConfig.setIgnoreDefaultExcludes(false);  //设置默认忽略
			jsonConfig.setExcludes(new String[]{"TSignins"});  //此处是亮点，
			JSONArray jsonarr = JSONArray.fromObject(al,jsonConfig);
			
			
			data = jsonarr.toString();
			System.out.println(data);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "queryAllSignin";
	}
}
