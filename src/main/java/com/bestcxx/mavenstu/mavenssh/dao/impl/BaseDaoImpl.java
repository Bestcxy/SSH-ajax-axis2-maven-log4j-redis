package com.bestcxx.mavenstu.mavenssh.dao.impl;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseDaoImpl <T, PK extends Serializable>{
	protected SessionFactory sessionFactory;

	@Autowired
    public void setSessionFactory(SessionFactory sessionfactory){
		this.sessionFactory = sessionfactory;
    }

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
	/**
	 * 获得Dao对于的实体类
	 *
	 * @return
	 */
	abstract protected Class<T> getEntityClass();
	
	/**
	 * @see Session.get(Class,Serializable)
	 * @param id
	 * @return 持久化对象
	 */
	protected T get(PK pk) {
		@SuppressWarnings("unchecked")
		T entity = (T) getSession().get(getEntityClass(), pk);
		return entity;
	}
	
	/**
	 * 返回符合hql搜索条件的 对象 队列 
	 * 如果有额外条件则使用map将字段名和值放置到map中
	 * 注意key值和实体类名字一致
	 */
	@SuppressWarnings("unchecked")
	protected List<T> getAnyListByHql(String hql,Map<String,String> map){
		Query query=getSession().createQuery(hql);
		
		if(map!=null){
			Set<String> set=map.keySet();
			Iterator<String> it=set.iterator();
			while(it.hasNext()){
				String temKey=it.next();
				query.setParameter(temKey, map.get(temKey));
			}
		}
		
		return (List<T>)query.list();
		
	}
	
	/**
	 * 返回符合hql搜索条件的 对象 队列 
	 * 如果有额外条件则使用map将字段名和值放置到map中
	 * 注意key值和数据库字段名字一致
	 */
	@SuppressWarnings("unchecked")
	protected List<T> getAnyListBySql(String sql,Map<String,String> map){
		Query query=getSession().createSQLQuery(sql);
		
		if(map!=null){
			Set<String> set=map.keySet();
			Iterator<String> it=set.iterator();
			while(it.hasNext()){
				String temKey=it.next();
				query.setParameter(temKey, map.get(temKey));
			}
		}
		
		return (List<T>)query.list();
	}
}
