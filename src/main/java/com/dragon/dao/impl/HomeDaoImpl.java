package com.dragon.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dragon.dao.HomeDao;
import com.dragon.model.Category;

@Repository("homeDao")
@Transactional
public class HomeDaoImpl implements HomeDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Category> getAllCategory() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Category";
		Query query = session.createQuery(hql);
		List<Category> listBouygues = query.list();
		if (listBouygues == null || listBouygues.size() == 0) {
			return null;
		}
		return listBouygues;
	}

}
