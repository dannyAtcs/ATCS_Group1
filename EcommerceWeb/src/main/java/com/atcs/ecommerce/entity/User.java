package com.atcs.ecommerce.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.atcs.ecommerce.enums.Role;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String firstname;
	
	@Column
	private String lastname;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column
	private Role role;
	
	
	@OneToMany(mappedBy = "user", cascade=CascadeType.ALL)
	private List<Order> order;
	
	@OneToOne(cascade = CascadeType.MERGE, mappedBy = "users", fetch = FetchType.LAZY)
	private Wallet wallet;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private Cart cart;
	
	@OneToOne(cascade = CascadeType.MERGE, mappedBy = "userAdd", fetch = FetchType.LAZY)
	private Address address;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@JsonManagedReference
	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public User(int id, String firstname, String lastname, String email, String password, Role role, List<Order> order,
			Wallet wallet, Cart cart, Address address) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.role = role;
		this.order = order;
		this.wallet = wallet;
		this.cart = cart;
		this.address = address;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	
	
}
