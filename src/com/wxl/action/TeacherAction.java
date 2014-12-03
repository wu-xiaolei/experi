package com.wxl.action;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import com.opensymphony.xwork2.ActionContext;
import com.wxl.dao.TeacherDao;
import com.wxl.entity.TUsers;

public class TeacherAction extends BaseAction{
	TeacherDao td = new TeacherDao();
	String data;
	String class_;
	String date;
	String s_jie;
	ArrayList list = new ArrayList();
	String experimentName;
	public String getExperimentName() {
		return experimentName;
	}


	public void setExperimentName(String experimentName) {
		this.experimentName = experimentName;
	}


	public ArrayList getList() {
		return list;
	}


	public void setList(ArrayList list) {
		this.list = list;
	}


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
	/**
	 * 获取所有符合规格的签到的学生
	 * @return
	 */
	public String queryAllSignin(){
		try {
			//data=null;
			ArrayList al = td.getSigninStudent(class_, date, s_jie);
			
			//JsonConfig jsonConfig = new JsonConfig();  //建立配置文件
			//jsonConfig.setIgnoreDefaultExcludes(false);  //设置默认忽略
			//jsonConfig.setExcludes(new String[]{"TSignins"});  //此处是亮点，
			//JSONArray jsonarr = JSONArray.fromObject(al,jsonConfig);
			
			list = al;
			
			//data = jsonarr.toString();
			//System.out.println(data);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "queryAllSignin";
	}
	/**
	 * 教师发布实验
	 * @return realeseExp
	 */
	public String realeseExp(){
		data="";
		System.out.println("进入Action");
		String []allclass = class_.split(",");//获取所有班级
		ArrayList<TUsers> al=null;
		for(int i=0;i<allclass.length;i++){
			//获得该班级中全部的学生
			
			
				al = td.getAllStudentBaseOnClass(allclass[i]);
				System.out.println(allclass[i]);
				Map u= ActionContext.getContext().getSession();
				TUsers us = (TUsers) u.get("user");
				System.out.println(us.getUsername());
				if(td.insertStudentOnClass(al,experimentName,us.getUsername())){
					data="发布成功";
				}else{
					data="发布失败";
				}
		
			
		}	
		return "realeseExp";
	}
	
}
