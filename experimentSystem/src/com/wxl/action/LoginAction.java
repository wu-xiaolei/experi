package com.wxl.action;


import com.wxl.dao.UsersDao;
import com.wxl.entity.TSignin;
import com.wxl.entity.TUsers;

public class LoginAction extends BaseAction{
	private TUsers user=null;
	private TSignin signin = null;
	private UsersDao ud = new UsersDao();
	private String userno; //获取Ajax的参数
	private String password;
	private Integer grade;
	
	private String data;//向Ajax的请求返回信息
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	private String prompt="";
	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public String getUserno() {
		return userno;
	}

	public void setUserno(String userno) {
		this.userno = userno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	/**
	 * 登录：Action
	 * @return
	 */
	public String login() {
		user = new TUsers();
		user.setUserno(userno);
		user.setPassword(password);
		user.setGrade(grade);
		if(ud.checkPassword(user)){
			user = ud.getUser(userno);
			session.put("user", user);//将user对象放入session中
			//System.out.println(((TUsers)session.get("user")).getUserno());
			if(grade==1){
				return "manager";
			}else if(grade==0){
				return "teacher";
			}else{
				return "student";
			}
			
		}else{
			prompt="用户名或密码错误";
			return "fail";
		}
	}
	/**
	 * 转到签到页面的Action
	 * @return
	 */
	public String signin(){
		return "signin";
	}
	/**
	 * 签到用的Action  异步交互
	 * @return
	 */
	public String ajax(){
		//System.out.println("ajax进入");
		//System.out.println(userno);
		if(ud.check(userno)){		
			user=ud.getUser(userno);//根据获取userno获取user对象
			
			signin = new TSignin(user,"已签到",ud.getDate());
			
			if(ud.inputUser(signin)){
				data = "签到成功";
			}else{
				data = "签到失败";
			}
			
		}else{
			data = "用户名不存在";
		}
		
		return "qiandao";
	}
	/**
	 * 退出登录的Action
	 * @return
	 */
	public String exit(){
		session.clear();
		//System.out.println(session.get("user"));
		return "exit";
	}
}
