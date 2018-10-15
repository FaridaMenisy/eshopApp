package com.eshop.dao.tablets;


import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eshop.model.Tablets;

@Repository
@Transactional
public class TabletsDaoImpl implements TabletsDao {
	 @Autowired
	 private SessionFactory sessionFactory;
	 
	 protected Session getSession(){
	  return sessionFactory.getCurrentSession();
	 }

	public List displayTabletsItems() {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Tablets.class);
       return (List) criteria.list();
	}

	public void deleteTablets(int id) {
		// TODO Auto-generated method stub
		Tablets tablets = (Tablets) getSession().get(Tablets.class, id);
		getSession().delete(tablets);
		
	}

	public Tablets findTabletById(int id) {
		// TODO Auto-generated method stub
		return (Tablets) getSession().get(Tablets.class, id);
	}

	public void saveOrUpdate(Tablets tablets) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(tablets);
		
	}
	 
	

}
