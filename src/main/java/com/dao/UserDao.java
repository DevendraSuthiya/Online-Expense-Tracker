package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entity.User;

public class UserDao {
	private SessionFactory factory;
	private Session session;
	private Transaction tx;

	public UserDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	public boolean saveuser(User user) {
		boolean f=false;
		try {
			session = factory.openSession();
			tx= session.beginTransaction();
			session.save(user);
			tx.commit();
			f=true;
		}catch(Exception e) {
			if(tx!=null) {
				f=false;
				e.printStackTrace();
			}
		}
		return f;
	}
	public User login(String email, String password) {
		User user=null;
		session = factory.openSession();
		Query q = session.createQuery("from User where email=:em and password=:ps");
	      q.setParameter("em" ,email);
	      q.setParameter("ps", password);
	      user = (User)q.uniqueResult();
	      
		return user;
	}
	

}
