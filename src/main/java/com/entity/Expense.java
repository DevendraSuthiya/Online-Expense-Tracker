package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Expense {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	private String date;
	private String time;
	@Column(name="pay_way")
	private String payWay;
	private String description;
	private String price;
	@ManyToOne
	private User user;
	public Expense() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Expense( String title, String date, String time, String payWay, String description, String price,
			User user) {
		super();
		this.title = title;
		this.date = date;
		this.time = time;
		this.payWay = payWay;
		this.description = description;
		this.price = price;
		this.user = user;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPayWay() {
		return payWay;
	}
	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Expense [id=" + id + ", title=" + title + ", date=" + date + ", time=" + time + ", payWay=" + payWay
				+ ", description=" + description + ", price=" + price + ", user=" + user + "]";
	}
	
	
	

}
