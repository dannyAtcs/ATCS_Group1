package com.atcs.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atcs.ecommerce.entity.Address;
import com.atcs.ecommerce.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController  {
	@Autowired
	AddressService addressservice;
	@GetMapping("/")
	public List<Address> getAllAddress()
	{
		return addressservice.getAllAddress();
		
	}
	
	@GetMapping("/{id}")
	public Address getAddressId(@PathVariable("id") int id)
	{
		return addressservice.findAddressById(id);
	}
	
	@PostMapping("/")
	public ResponseEntity<String> postData(@RequestBody Address address)
	{
		return addressservice.postData(address);
	}
	 
	@PutMapping("/")
	public void updateData(@RequestBody Address address)
	{
		addressservice.putData(address);
	}
	
	@DeleteMapping("/{id}")
	public void deleteAddressId(@PathVariable("id") int id)
	{
		addressservice.deleteAddressById(id);
	}

}