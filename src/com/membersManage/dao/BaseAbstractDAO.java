package com.membersManage.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public abstract class BaseAbstractDAO<T, ID extends Serializable>  extends HibernateDaoSupport
implements	IGenericDAO<T, ID> {

	private Class<T> persistentClass;

	public BaseAbstractDAO(Class c) {
		persistentClass = c;
	}

	public T findById(ID id) {
		return (T) getHibernateTemplate().get(persistentClass, id);
	}
	
	public T save(T entity) {
		getHibernateTemplate().saveOrUpdate(entity);
		return entity;
	}

	public void delete(T entity) {
		getHibernateTemplate().delete(entity);
	}

	public void delete(ID id) {
		getHibernateTemplate().delete(findById(id));
	}
	
	public List<T> findByExample(T exampleEntity) {
		return getHibernateTemplate().findByExample(exampleEntity);
	}
	
	public List<T> findByExample(T exampleEntity, int firstResult, int maxResults) {
		return getHibernateTemplate().findByExample(exampleEntity, firstResult, maxResults);
	}
	
	public List<T> find(String queryString) {
		return getHibernateTemplate().find(queryString);
	}
	
	public List<T> find(String queryString, int maxResults) {
		HibernateTemplate ht = getHibernateTemplate();
		ht.setMaxResults(maxResults);
		return ht.find(queryString);
	}

	public List<T>find(String queryString, Object [] objArray){
		HibernateTemplate ht = getHibernateTemplate();
		return ht.find(queryString, objArray);
	}
	
	public List<T> findByNamedQuery(String queryName) {
		return getHibernateTemplate().findByNamedQuery(queryName);
	}
	
	public List<T> findByNamedQuery(String queryName, int maxResults) {
		HibernateTemplate ht = getHibernateTemplate();
		ht.setMaxResults(maxResults);
		return ht.findByNamedQuery(queryName);
	}
	
	public List<T> findByCriteria(DetachedCriteria criteria) {
		return getHibernateTemplate().findByCriteria(criteria);
	}
	
	public List<T> findByCriteria(DetachedCriteria criteria,int firstResult,int maxResults) {
		return getHibernateTemplate().findByCriteria(criteria, firstResult, maxResults);
	}
	
	public List<T> saveOrUpdateAll(List<T> list ){
		getHibernateTemplate().saveOrUpdateAll(list);
		return list;
	}
}
