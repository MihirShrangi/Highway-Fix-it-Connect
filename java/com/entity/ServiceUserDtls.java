package com.entity;

public class ServiceUserDtls {
	
	private int id;
	private int mid;
	private String mname;
	private String name; 
	private String mobile;
	private String service;
	private String  location; 
	private String status;
	
	public ServiceUserDtls() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	 
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ServiceUserDtls [id=" + id + ", mid=" + mid + ", mname=" + mname + ", name=" + name + ", unqid=" + mobile
				+ ", service=" + service + ", location=" + location + ", status=" + status + "]";
	}

	 
	
	
}
