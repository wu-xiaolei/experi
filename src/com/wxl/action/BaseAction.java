package com.wxl.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

public class BaseAction implements SessionAware {
	protected Map<String,Object> session;
	
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;

	}
	


}
