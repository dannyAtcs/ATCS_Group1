package com.atcs.ecommerce.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.atcs.ecommerce.entity.Address;

@Service
public interface AddressService {
	public List<Address> getAllAddress();
	public Address findAddressById(int id);
	public ResponseEntity<String> postData(Address address) ;
	public void putData(Address address);
	public void deleteAddressById(int id);

}