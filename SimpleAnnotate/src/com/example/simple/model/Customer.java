package com.example.simple.model;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="customer")
public class Customer {

	@Attribute
	private int id;
	@Element
	private String name;
	@Element
	private String phone;
	@Element(data=true)
	private String about;
	@Element
	private int age;
	@Element
	private BigDecimal balance;
	@Element
	private boolean active;
	@Element
	private Date joined;

	//data item names from JSON file
	public static final String 
	ID="id",
	NAME="name",
	PHONE="phone",
	ABOUT="about",
	AGE="age",
	BALANCE="balance",
	ACTIVE="active",
	JOINED="joined";

	public Customer() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setId(Number id) {
		this.id = id.intValue();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public void setBalance(String balance) {
		this.balance = new BigDecimal(balance);
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setAge(Number age) {
		this.age = age.intValue();
	}
	public boolean getActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public void setActive(String isActive) {
		this.active = Boolean.parseBoolean(isActive);
	}
	public Date getJoined() {
		return joined;
	}
	public void setJoined(Date joined) {
		this.joined = joined;
	}
	public void setJoined(String joined) {
		//This format matches the date format in the JSON data file
		DateFormat inputDate = DateFormat.getDateInstance(DateFormat.SHORT);
		try {
			this.joined = inputDate.parse(joined);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
		return this.id + ". " + this.name + " joined " + df.format(this.joined);
	}

}
