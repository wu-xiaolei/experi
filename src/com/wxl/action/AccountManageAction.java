package com.wxl.action;

import com.wxl.dao.UsersDao;
import com.wxl.entity.TUsers;

public class AccountManageAction extends BaseAction {
	UsersDao ud = new UsersDao();
	private String oldpassword;
	private String newpassword1;
	private String username;
	private String userno;
	private int userid;
	private String class_;
	private TUsers user=null;
	String data;
	
	public String getClass_() {
		return class_;
	}

	public void setClass_(String class1) {
		class_ = class1;
	}

	public String getUserno() {
		return userno;
	}

	public void setUserno(String userno) {
		this.userno = userno;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getData() {
		return data;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getOldpassword() {
		return oldpassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	public String getNewpassword1() {
		return newpassword1;
	}

	public void setNewpassword1(String newpassword1) {
		this.newpassword1 = newpassword1;
	}

	public String changePassword(){
		user = new TUsers();
		user.setPassword(oldpassword);
		if(ud.checkPassword(user)){
			if(ud.updatePassword(userid,newpassword1)){
				data="密码修改成功！";
			}else{
				data="密码修改失败！";
			}
		}else{
			data="原密码输入有误！";
		}
		return "changePassword";
	}
	public String delUser(){
		if(ud.del(userid)){
			data="删除成功";
		}else{
			data="删除失败";
		}
		return "delUser";
	}
	
	public String delStudent(){
		if(ud.del(userid)){
			data="删除成功";
		}else{
			data="删除失败";
		}
		return "delStudent";
	}
	
	public String delTeacher(){
		if(ud.del(userid)){
			data="删除成功";
		}else{
			data="删除失败";
		}
		return "delTeacher";
	}
	/**
	 * 账号管理中修改用户信息
	 * @return
	 */
	public String updateUser(){
		if(ud.updateUser(userid, username, oldpassword,null)){
			data="修改成功！";
		}else{
			data="修改失败！";
		}
		return "updateUser";
	}
	/**
	 * 添加用户检测用户名是否被占用
	 * @return
	 */
	public String checkUsername(){
		
		if(ud.check(userno)){
			data="账号已经被占用！";
		}else{
			data="账号可以使用";
		}
		return "checkUsername";
	}
	/**
	 * 添加用户
	 * @return
	 */
	public String addUser(){
		user = new TUsers(userno,username,oldpassword,1);
		if(ud.addUser(user)){
			data="添加成功！";
		}else{
			data="添加失败！";
		}
		return "addUser";
	}
	public String updateStudent(){
		if(ud.updateUser(userid, username, oldpassword,class_)){
			data="修改成功！";
		}else{
			data="修改失败！";
		}
		
		return "updateStudent";
	}
	
	/**
	 * 添加学生
	 * @return
	 */
	public String addStudent(){
		user = new TUsers(userno,username,oldpassword,-1);
		user.setClass_(class_);
		if(ud.addUser(user)){
			data="添加成功！";
		}else{
			data="添加失败！";
		}
		return "addStudent";
	}
	/**
	 * 添加教师
	 * @return
	 */
	public String addTeacher(){
		user = new TUsers(userno,username,oldpassword,0);
		if(ud.addUser(user)){
			data="添加成功！";
		}else{
			data="添加失败！";
		}
		return "addTeacher";
	}
}
