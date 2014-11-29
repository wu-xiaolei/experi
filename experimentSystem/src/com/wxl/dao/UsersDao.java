package com.wxl.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.wxl.entity.TSignin;
import com.wxl.entity.TUsers;
import com.wxl.util.HibernateUtil;

/**
 * 处理用户的业务逻辑
 * @version 1.0
 * @author wu_xiaolei
 *
 */
public class UsersDao {
	
	private Session session=null;
	private Transaction tx = null;
	
	/**
	 * 根据级别查询用户
	 * @param grade  级别
	 * @return  list用户列表
	 */
	public List<TUsers> showUser(int grade){
		List<TUsers> list=null;
		try{
		session = HibernateUtil.getSession();//获取session对象
		Criteria criteria = session.createCriteria(TUsers.class);//创建criteria查询对象
		list =criteria.add(Restrictions.eq("grade", grade)).list();
		}catch(HibernateException he){
			he.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return list;
	}
	/**
	 * 签到时     验证用户
	 * @param user 传入user对象
	 * @return true:有此用户  false：无此用户
	 */
	@SuppressWarnings("unchecked")
	public boolean check(String userno){
		boolean isNo=false;
		session = HibernateUtil.getSession();//获取session对象
		Criteria criteria = session.createCriteria(TUsers.class);//创建criteria查询对象
		List<TUsers> list =criteria.add(Restrictions.eq("userno", userno)).list();
		if(list.isEmpty()){
			isNo=false;
			
		}else{
			isNo=true;
		}
		if(session!=null){
			HibernateUtil.closeSession();
		}
		return isNo;
	}
	/**
	 * 登录验证密码   签到
	 * @param user 传入user对象   动态查询
	 * @return true:成功  false：失败
	 */
	public boolean checkPassword(TUsers user){
		boolean isNo=false;
		session = HibernateUtil.getSession();//获取session对象
		Criteria criteria = session.createCriteria(TUsers.class);//创建criteria查询对象
		if(user.getUserid()!=null){
			criteria.add(Restrictions.eq("userno", user.getUserno()));
		}
		if(user.getPassword()!=null){
			criteria.add(Restrictions.eq("password", user.getPassword()));
		}
		if(user.getGrade()!=null){
			criteria.add(Restrictions.eq("grade", user.getGrade()));
		}
		List<TUsers> list =criteria.list();
		if(list.isEmpty()){
			isNo=false;
			
		}else{
			isNo=true;
		}
		if(session!=null){
			HibernateUtil.closeSession();
		}
		return isNo;
	}
	/**
	 * 添加管理员，教师,学生
	 * @param user  传入user对象
	 * @return true:成功  false：失败
	 */
	public boolean addUser(TUsers user){
		boolean isNo=true;
		session = HibernateUtil.getSession();//获取session对象
		//开启一个事务
		tx = session.beginTransaction();
		try{
			session.save(user);
			tx.commit();
		}catch(HibernateException e){
			isNo = false;
			e.printStackTrace();
			
		}finally{
			if(session!=null){
				HibernateUtil.closeSession();
			}
		}
		return isNo;
		
	}
	/**
	 * 根据no删除用户
	 * @param userid
	 * @return true:成功  false：失败
	 */
	public boolean del(int userid){
		boolean isNo=true;
		session = HibernateUtil.getSession();//获取session对象
		//开启一个事务
		tx = session.beginTransaction();
		TUsers user = (TUsers) session.load(TUsers.class,userid);
		try{
			session.delete(user);
			tx.commit();
		}catch(HibernateException e){
			isNo = false;
			e.printStackTrace();
			
		}finally{
			if(session!=null){
				HibernateUtil.closeSession();
			}
		}
		return isNo;
		
	}
	/**
	 * 修改密码
	 * @param userid  用护账号
	 * @param password  密码
	 * @return true:成功  false：失败
	 */
	public boolean updatePassword(int userno,String password){
		boolean isNo=true;
		session = HibernateUtil.getSession();//获取session对象
		//开启一个事务
		tx = session.beginTransaction();
		TUsers user = (TUsers) session.load(TUsers.class,userno);
		try{
			user.setPassword(password);
			session.update(user);
			tx.commit();
		}catch(HibernateException e){
			isNo = false;
			e.printStackTrace();
			
		}finally{
			if(session!=null){
				HibernateUtil.closeSession();
			}
		}
		return isNo;
	}
	
	/**
	 * 管理员修改用户信息
	 * @param userid 用户ID
	 * @param username 用户名
	 * @param password 用户密码
	 * @return
	 */
	public boolean updateUser(int userid,String username,String password,String class_){
		boolean isNo=true;
		session = HibernateUtil.getSession();//获取session对象
		//开启一个事务
		tx = session.beginTransaction();
		TUsers user = (TUsers) session.load(TUsers.class,userid);
		try{
			user.setUsername(username);
			user.setPassword(password);
			user.setClass_(class_);
			session.update(user);
			tx.commit();
		}catch(HibernateException e){
			isNo = false;
			e.printStackTrace();
			
		}finally{
			if(session!=null){
				HibernateUtil.closeSession();
			}
		}
		return isNo;
	}
	
	/**
	 * 根据userno返回user对象
	 * @param userno
	 * @return
	 */
	public TUsers getUser(String userno){
		
		session = HibernateUtil.getSession();//获取session对象
		TUsers user = (TUsers) session.createCriteria(TUsers.class).add(Restrictions.eq("userno", userno)).uniqueResult();
		return user;
	}
	/**
	 * 往签到表中添加签到学生
	 * @param signin
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean inputUser(TSignin signin){
		boolean isNo = false;
		session = HibernateUtil.getSession();//获取session对象
		//开启一个事务
		tx = session.beginTransaction();
		
		try{
			//signin.setTUsers(user);
			//user.getTSignins().add(signin);
			session.save(signin);
			tx.commit();
			isNo = true;
		}catch(HibernateException e){
			isNo = false;
			e.printStackTrace();
			
		}finally{
			if(session!=null){
				HibernateUtil.closeSession();
			}
		}
		
		return isNo;
		
	}
	
	/**
	 * 获得系统当前时间
	 * @return 时间字符串
	 */
	public Date getDate(){
		Date date = new Date();
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//String now = sdf.format(date);
		return date;
	}
	
	
	
	/**
	 * 测试方法
	 */
	@Test
	public void che(){
		TUsers use  = new TUsers("1060","admin","admin",1);
		TUsers user = new TUsers();
		//user.setUserid("1000");
		//user.setPassword("admin");
		System.out.println(addUser(use));
		//System.out.println(del("1001"));
		//System.out.println(checkPassword(use));
		//System.out.println(getDate());
		//System.out.println(check(user.getUserid()));
		
	}
}
