package com.membersManage.dao;


import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface IGenericDAO < T, ID extends Serializable >{

	  T findById(ID id);
	  
	  T save( T entity);
	  
	  void delete(T entity);
	  
	  void delete(ID id);
	  
	  List<T> findByCriteria(DetachedCriteria criteria);
	  
	  List<T> findByCriteria(DetachedCriteria criteria, int firstResult, int maxResults);
	  
	  List<T> findByNamedQuery(String queryName);
	  
	  List<T> findByNamedQuery(String queryName, int maxResults);

	  List<T> find(String queryString);
	  
	  List<T> find(String queryString, int maxResults);

	  List<T> find(String queryString, Object [] objArray);
	  
	  List<T> findByExample(T exampleEntity);
	  
	  List<T> findByExample(T exampleEntity, int firstResult, int maxResults);
	  
	  List<T> saveOrUpdateAll(List<T> list);
}
