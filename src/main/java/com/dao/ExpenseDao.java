package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entity.Expense;
import com.entity.User;

public class ExpenseDao {
	private SessionFactory factory;
	private Session session;
	private Transaction tx;
	public ExpenseDao(SessionFactory factory) {
		super();
		this.factory=factory;
	}
	
	public boolean saveExpense(Expense ex) {
		boolean flag = false;
		try {
			session = factory.openSession();
			tx= session.beginTransaction();
			session.save(ex);
			tx.commit();
			flag=true;
			
			
		}catch(Exception e) {
			if(tx!=null) {
				flag=false;
				e.printStackTrace();
				
			}
		}
		return flag;
	}
 public List<Expense> getAllExpenseByUser(User user){
	 try {
		 session = factory.openSession();
		 Query q =session.createQuery("from Expense where user=:u");
		 q.setParameter("u", user);
		 List<Expense> list = q.list();
		 return list;
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	 return new ArrayList<>();
 }
 public Expense getExpenseById(int id) {
	 Expense ex=null;
	 try {
		 session = factory.openSession();
		 ex=(Expense)session.get(Expense.class, id);
		 
		 
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	 return ex;
 }
 public boolean updateExpense(Expense ex) {
		boolean flag = false;
		try {
			session = factory.openSession();
			tx= session.beginTransaction();
			session.saveOrUpdate(ex);
			tx.commit();
			flag=true;
			
			
		}catch(Exception e) {
			if(tx!=null) {
				flag=false;
				e.printStackTrace();
				
			}
		}
		return flag;
	}
 public boolean deleteExpense(int id) {
	 boolean flag =false;
	 try {
		 session = factory.openSession();
		 tx= session.beginTransaction();
		 Expense ex =(Expense)session.get(Expense.class, id);
		 session.delete(ex);
		 tx.commit();
		 flag=true;
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	 return flag;
 }
}
