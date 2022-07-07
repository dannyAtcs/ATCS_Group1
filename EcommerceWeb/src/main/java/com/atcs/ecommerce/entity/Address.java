package com.atcs.ecommerce.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String address;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private String country;
	@Column
	private String landmark;
	@Column
	private int pincode;
	

	@OneToOne(cascade = CascadeType.MERGE)
	private User userAdd;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	


	public Address(int id, String address, String city, String state, String country, String landmark, int pincode,
			User userAdd) {
		super();
		this.id = id;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.landmark = landmark;
		this.pincode = pincode;
		this.userAdd = userAdd;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@JsonBackReference
	public User getUserAdd() {
		return userAdd;
	}


	public void setUserAdd(User userAdd) {
		this.userAdd = userAdd;
	}

	

	
	
	
}
