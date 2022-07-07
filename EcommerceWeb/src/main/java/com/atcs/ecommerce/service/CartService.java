package com.atcs.ecommerce.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.atcs.ecommerce.entity.Cart;


@Service
public interface CartService {
	
	public List<Cart> getData();

	public void postData(Cart car);

	public void putData(Cart car);

	public void deleteData(int id);

	public Cart getDataById(int id);
	
	public ResponseEntity<String> addToCart(int id1,int id2);
	
	public void removeToCart(int id1, int id2);

}
