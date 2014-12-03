package com.wxl.dao;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;


import com.wxl.entity.TExperiment;
import com.wxl.entity.TUsers;
import com.wxl.util.HibernateUtil;


public class TeacherDao {
	
	/**
	 * 获得所有班级
	 * @return Arraylist
	 */
	public ArrayList getAllClass(){
		Session session =null;
		ArrayList<String> al = new ArrayList<String>();
		String hql="select distinct class_ from TUsers";
		try {
			session = HibernateUtil.getSession();
			Query query = session.createQuery(hql);
			al = (ArrayList<String>) query.list();
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			if(session!=null){
				HibernateUtil.closeSession();
			}
		}
		return al;
	}
	/**
	 * 根据条件查询签到学生信息
	 * @param class_ 班级
	 * @param date 日期
	 * @param jie 节数
	 * @return Arraylist学生集合
	 * @throws ParseException
	 */
	public ArrayList getSigninStudent(String class_,String date,String jie) throws ParseException{
		ArrayList<TUsers> al = new ArrayList<TUsers>();
		//DateFormat df = new SimpleDateFormat("hh:mm:ss");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		java.util.Date start=null;
		java.util.Date end=null;
		//java.util.Date d;
		java.util.Date d1;
		java.util.Date d2;
		Session session =null;
		try{
			session = HibernateUtil.getSession();
			Criteria criteria = session.createCriteria(TUsers.class,"user").createAlias("TSignins", "signin");
			if(class_!=null){
				criteria.add(Restrictions.eq("user.class_", class_));
			}
			if(date!=null&&!date.equals("")){
				DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				DateFormat df3 = new SimpleDateFormat("yyyy-MM-dd");
				//d = df3.parse(date);
				d1 =  df2.parse(date+" 00:00:00");
				d2 =  df2.parse(date+" 23:59:59");
				criteria.add(Restrictions.between("signin.indate", d1, d2));
				
			}
			if(jie!=null&&date!=null&&!jie.equals("")&&!date.equals("")&&!jie.equals("sele")){
				
				if(jie.equals("ot")){
					try {
						start= df.parse(date+" 8:30:00");
						end =  df.parse(date+" 10:05:00");
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(jie.equals("tf")){
					try {
						start= df.parse(date+" 10:20:00");
						end = df.parse(date+" 12:55:00");
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(jie.equals("fs")){
					try {
						start= df.parse(date+" 14:00:00");
						end =  df.parse(date+" 15:35:00");
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(jie.equals("se")){
					try {
						start= df.parse(date+" 15:50:00");
						end =  df.parse(date+" 17:25:00");
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(jie.equals("nt")){
					try {
						start= df.parse(date+" 19:00:00");
						end =  df.parse(date+" 21:00:00");
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				criteria.add(Restrictions.between("signin.indate", start, end));
				
			}
			al =  (ArrayList<TUsers>) criteria.list();
		}catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return al;
	}
	/**
	 * 根据班级返回该班级中的学生人数
	 * @param class_ 班级
	 * @return Arraylist 学生集合
	 */
	public ArrayList getAllStudentBaseOnClass(String class_){
		Session session =null;
		ArrayList<TUsers> al = new ArrayList<TUsers>();
		String hql="from TUsers where class_ ='"+class_+"'";
		try {
			session = HibernateUtil.getSession();
			Query query = session.createQuery(hql);
			al = (ArrayList<TUsers>) query.list();
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			if(session!=null){
				HibernateUtil.closeSession();
			}
		}
		return al;
	}
	
	public boolean insertStudentOnClass(ArrayList<TUsers> al,String experimentname,String teacher){
		boolean flag = false;
		Session session=null;
		try{
			session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			for(TUsers student:al){
				TExperiment experiment = new TExperiment(student,experimentname,0);
				experiment.setTeacher(teacher);
				session.save(experiment);
				
			}
			tx.commit();
			flag =true;
		}catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return flag;
	}
	
	/**
	 * 测试方法
	 * @throws ParseException 
	 */
	@Test
	public void test() throws ParseException{
		/*//测试查询所有班级
		ArrayList al = getAllClass();
		for(int i=0;i<al.size();i++){
			if(al.get(i)!=null){
				System.out.println(al.get(i));
			}
		}*/
		
		//测试查询签到人数
		/*ArrayList al = getSigninStudent("软工1班", null, null);
		for(int i=0;i<al.size();i++){
			
				System.out.println(((TUsers) al.get(i)).getUsername());
			
		}*/
		
		ArrayList al = getAllStudentBaseOnClass("软工2班");
		for(int i=0;i<al.size();i++){
			
			System.out.println(((TUsers) al.get(i)).getUsername());
		
	}
	}
}
