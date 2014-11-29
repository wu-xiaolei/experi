package com.wxl.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.wxl.entity.Information;
import com.wxl.util.HibernateUtil;

/**
 * 处理管理员的逻辑类
 * @author wu_xiaolei
 *
 */
public class ManagerDao {
	private Session session = null;
	private Transaction tx = null;
	
	/**
	 * 根据id查找内容显示公告
	 * @param id
	 * @return
	 */
	public String[] getContent(int id){
		Information info=null;
		String s[] = new String[2];
		try{
			session = HibernateUtil.getSession();
			info= (Information) session.load(Information.class, id);
			s[0] = info.getInformationtitle();
			s[1] = info.getInformation();
		}catch(HibernateException ex){
			ex.printStackTrace();
			
		}finally{
			if(session!=null){
				HibernateUtil.closeSession();
			}
		}
		return s;
	}
	
	
	
	/**
	 * 查询所有公告信息
	 * @return List<Information> 
	 */
	public List<Information> showAllInformation(){
		List<Information> informations=null;
		try{
			session = HibernateUtil.getSession();
			informations = session.createCriteria(Information.class).list();
		}catch(HibernateException ex){
			ex.printStackTrace();
			
		}finally{
			if(session!=null){
				HibernateUtil.closeSession();
			}
		}
		return informations;
	}
	/**
	 * 添加公告信息
	 * @param information
	 * @return false:添加失败  true:添加成功
	 */
	public boolean addInfo(Information information){
		boolean isOk = false;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.save(information);
			tx.commit();
			isOk = true;
		}catch(HibernateException ex){
			isOk = false;
			ex.printStackTrace();
		}finally{
			if(session!=null){
				HibernateUtil.closeSession();
			}
		}
		return isOk;
	}
	/**
	 * 修改公告信息
	 * @param information
	 * @return false:修改失败  true:修改成功
	 */
	public boolean updateInfo(Information infomation){
		boolean isOk = false;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			Information info = (Information) session.load(Information.class,infomation.getInformationid());
			info.setInformationtitle(infomation.getInformationtitle());
			info.setInformation(infomation.getInformation());
			session.update(info);
			tx.commit();
			isOk = true;
		}catch(HibernateException ex){
			isOk = false;
			ex.printStackTrace();
		}finally{
			if(session!=null){
				HibernateUtil.closeSession();
			}
		}
		return isOk;
	}
	
	/**
	 * 删除公告信息
	 * @param informationid  根据id删除
	 * @return false:删除失败  true:删除成功
	 */
	public boolean deleteInfo(int informationid){
		boolean isOk = false;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			Information info = (Information) session.load(Information.class, informationid);
			session.delete(info);
			tx.commit();
			isOk = true;
		}catch(HibernateException ex){
			isOk = false;
			ex.printStackTrace();
		}finally{
			if(session!=null){
				HibernateUtil.closeSession();
			}
		}
		return isOk;
	}
	
	/**
	 * 获得登录界面的公告信息
	 * @return list集合
	 */
	public List<Information> getLoginInfo(){
		List<Information> list1 = showAllInformation();
		List<Information> list = new ArrayList<Information>();
		for(int i=0;i<list1.size();i++){
			int j=0;
			list.add(list1.get(i));
			j++;
			//控制登录界面显示的公告条数
			if(j>=6){
				break;
			}
		}
		return list;
	}
	
	@Test
	public void test(){
		System.out.println(showAllInformation().size());
	}
}
