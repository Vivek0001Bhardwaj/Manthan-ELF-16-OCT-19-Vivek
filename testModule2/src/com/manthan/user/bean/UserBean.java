package com.manthan.user.bean;

public class UserBean {

	private String userName;
	private String password;
	private int age;
	private String gender;
	private String confPassword;
	
	public synchronized String getConfPassword() {
		return confPassword;
	}
	public synchronized void setConfPassword(String confPassword) {
		this.confPassword = confPassword;
	}
	public synchronized String getUserName() {
		return userName;
	}
	public synchronized void setUserName(String userName) {
		this.userName = userName;
	}
	public synchronized String getPassword() {
		return password;
	}
	public synchronized void setPassword(String password) {
		this.password = password;
	}
	public synchronized int getAge() {
		return age;
	}
	public synchronized void setAge(int age) {
		this.age = age;
	}
	public synchronized String getGender() {
		return gender;
	}
	public synchronized void setGender(String gender) {
		this.gender = gender;
	}
	
}//End of class
