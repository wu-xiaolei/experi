package com.wxl.action;

import java.util.List;

import com.wxl.dao.ManagerDao;
import com.wxl.dao.UsersDao;
import com.wxl.entity.Information;
import com.wxl.entity.TUsers;

public class SkipAction extends BaseAction{
	private ManagerDao md = new ManagerDao();
	private UsersDao ud = new UsersDao();
	private Integer informationid;
	
	public Integer getInformationid() {
		return informationid;
	}
	public void setInformationid(Integer informationid) {
		this.informationid = informationid;
	}
	private List<Information> list;//输出公告信息   用户列表信息
	private List<TUsers> listUser;//   用户列表信息
	
	public List<TUsers> getListUser() {
		return listUser;
	}
	public void setListUser(List<TUsers> listUser) {
		this.listUser = listUser;
	}
	public String relreaseInfo(){
		setList(md.showAllInformation());
		return "relreaseInfo";
	}
	public String labManager(){
		return "lab";
	}
	public String  experimentManger(){
		return "experimentManager";
	}
	public String studentManage(){
		listUser = ud.showUser(-1);
		return "studentManage";
	}
	public String teacherManage(){
		listUser = ud.showUser(0);
		return "teacherManage";
	}
	public String accountManage(){
		listUser = ud.showUser(1);
		return "accountManage";
	}
	public void setList(List<Information> list) {
		this.list = list;
	}
	public List<Information> getList() {
		return list;
	}
	
	public String updateInfo(){
		System.out.println(informationid);
		return "updateInfo";
	}
	
	/**
	 * 教师界面跳转
	 */
	public String setInformation(){
		
		return "setInformation";
	}
	
	public String controlExperiment(){	
		return "controlExperiment";
	}
	
	public String labReport(){	
		return "labReport";
	}
	public String querySignin(){	
		return "querySignin";
	}
	
}
