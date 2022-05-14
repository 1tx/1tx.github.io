package com.entity;

//用户
public class User  {

	private int id;//主键
	
	private String username;//用户名
	
	private String password;//密码
	
	private int role;//用户角色，1表示系统管理员，3表示用户
	
	private String name;//姓名
	
	private String phone;//手机号码
	
	private String ctime;//注册时间

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
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

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	
	

	
	
	
	
	
	
}
