package com.wxl.action;

import java.util.List;

import net.sf.json.JSONArray;



import com.wxl.dao.ManagerDao;
import com.wxl.entity.Information;

public class InformationAction extends BaseAction {
	private Integer informationid;
	private String informationtitle;//公告名称，用于超链接
	private String information;//公告内容，用于用户点击超链接后，转向的页面
	private ManagerDao md = new ManagerDao();
	private Information informations=null;
	String data;//用户登录界面返回的公告集合
	private List<Information> list=null;//输出公告信息
	private String message;
	
	public String getData() {
		return data;
	}

	public void setDate(String data) {
		this.data = data;
	}

	public Integer getInformationid() {
		return informationid;
	}

	public void setInformationid(Integer informationid) {
		this.informationid = informationid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getInformationtitle() {
		return informationtitle;
	}

	public void setInformationtitle(String informationtitle) {
		this.informationtitle = informationtitle;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public List<Information> getList() {
		return list;
	}

	public void setList(List<Information> list) {
		this.list = list;
		
	}
	
	public String showAllInformation(){
		
		return "notice";
	}
	
	public String addInfo(){
		informations = new Information();
		informations.setInformationtitle(informationtitle);
		informations.setInformation(information);
		list = md.showAllInformation();
		if(md.addInfo(informations)){
			
			message="添加成功！";
		}else{
			message="添加失败！";
		}
		return "add";
	}
	public String del(){
		
		if(md.deleteInfo(informationid)){			
			message="删除成功！";
			return "del";
		}else{
			message="删除失败！";
		}
		return "del";
		
	}
	
	public String updateInfo(){
		informations = new Information(informationtitle,information);
		informations.setInformationid(informationid);
		//System.out.println(informationid+"----"+informationtitle+"--------"+information);
		if(md.updateInfo(informations)){
			
			message="修改成功！";
		}else{
			
			message="修改失败！";
		}
		return "updateInfo";
	}
	/**
	 * 用于登录界面放回公告
	 * @return
	 */
	public String getInfo(){
		list = md.getLoginInfo();
		//System.out.println("ajax进入Action");
		JSONArray jsonarr = JSONArray.fromObject(list);
		data = jsonarr.toString();
		//System.out.println(data);
		//session.put("list", list);//放入session
		return "getInfo";
	}
	/**
	 * 显示公告界面
	 * @return
	 */
	public String toNotice(){
		String s[] = md.getContent(informationid);
		System.out.println(s[0]+"  "+s[1]);
		informationtitle = s[0];
		information = s[1];
		return "toNotice";
	}
}
