package com.model;



public class Model {

	int id;
	String fname, lname, address, email, uname, pass, phone;
	String name;
	String cost;
	String product;
	String photo;
	public Model() {
	}


	

	public Model(int id, String name, String cost, String product, String photo) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.product = product;
		this.photo = photo;
	}

	public Model(String name, String cost, String product, String photo) {
		super();
		this.name = name;
		this.cost = cost;
		this.product = product;
		this.photo = photo;
	}




	public Model(int id) {
		super();
		this.id = id;
	}


	public Model(int id, String fname, String lname, String address, String email, String uname, String pass,
			String phone) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.email = email;
		this.uname = uname;
		this.pass = pass;
		this.phone = phone;
	}


	public Model(int id, String uname) {
		super();
		this.id = id;
		this.uname = uname;
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCost() {
		return cost;
	}


	public void setCost(String cost) {
		this.cost = cost;
	}


	public String getProduct() {
		return product;
	}


	public void setProduct(String product) {
		this.product = product;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
