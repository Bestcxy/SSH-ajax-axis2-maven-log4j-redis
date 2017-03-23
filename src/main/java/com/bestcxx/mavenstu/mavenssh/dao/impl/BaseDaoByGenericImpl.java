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

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BaseDaoByGenericImpl <T, PK extends Serializable>{
	
	protected SessionFactory sessionFactory;

	@Autowired
    public void setSessionFactory(SessionFactory sessionfactory){
		this.sessionFactory = sessionfactory;
    }

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    protected Class<T> tClass;
	protected Class<PK> pkClass;
	
	//利用反射机制获取泛型类子类泛型参数的具体类型-这个必须写在构造方法中
	@SuppressWarnings("unchecked")
	public BaseDaoByGenericImpl() {
		tClass=(Class<T>) getModelClass(tClass, 0);
		pkClass=(Class<PK>) getModelClass(pkClass, 1);
		//System.out.println("泛型类构造方法获取到了第一个泛型参数具体类型 tClass="+tClass+"["+this.getClass()+"]");
		//System.out.println("泛型类构造方法获取到了第二个泛型参数具体类型  kClass="+pkClass+"["+this.getClass()+"]");
	}
	//泛型类作为父类，可以获取子类的所有实际参数的类型

	public Class<?> getModelClass(Class modelClass,int index){
		Type genType = this.getClass().getGenericSuperclass();// 得到泛型父类
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();//一个泛型类可能有多个泛型形参，比如ClassName<T,K> 这里有两个泛型形参T和K，Class Name<T> 这里只有1个泛型形参T
		if(params.length-1<index){
			modelClass=null;
		}else{
			modelClass=(Class) params[index];
		}
		
		return modelClass;
		
	}
	
	//--将泛型参数按照子类传入值实例化
	//当在构造方法中为下面泛型参数实例化的时候，可以直接在子类使用 tModel 或者 kMode 处理业务逻辑
	protected T tModel;
	protected PK pkModel;
	
	//将子类的泛型类实例化-获取实例化对象的方法
	@SuppressWarnings("unchecked")
	public <M> M getModel(Class<M> mClass,M mModel,int index) {
		try {
			mModel = (M) getModelClass(mClass,index).newInstance();
		} catch (Exception e) {
			mModel = null;
		}
		return mModel;
	}
	
	/**
	 * @see Session.get(Class,Serializable)
	 * @param id
	 * @return 持久化对象
	 */
	protected T get(PK pk) {
		@SuppressWarnings("unchecked")
		T entity = (T) getSession().get(tClass, pk);
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
	
	protected boolean add(T t){
		getSession().save(t);
		return true;
		
	}
}
