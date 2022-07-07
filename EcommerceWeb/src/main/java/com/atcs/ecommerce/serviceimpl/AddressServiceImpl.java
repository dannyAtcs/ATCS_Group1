package com.atcs.ecommerce.serviceimpl;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.atcs.ecommerce.entity.Address;
import com.atcs.ecommerce.repo.AddressRepo;
import com.atcs.ecommerce.service.AddressService;

@Component
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepo addressrepo;
	
	@Override
	public List<Address> getAllAddress() {
		
		return addressrepo.findAll();
	}

	@Override
	public Address findAddressById(int id) {
		
		return addressrepo.findById(id).get();
	}

	@Override
	public ResponseEntity<String> postData(Address address) {
		List<Integer> pincode = new ArrayList<>();
		Collections.addAll(pincode, 100000, 100001, 100002, 100003, 100004, 100005, 100006, 100007, 100008, 100009, 100010, 100011, 100012, 100013, 100014);
		for(Integer in: pincode) {
			if(address.getPincode()==in) {
				addressrepo.save(address);
				return ResponseEntity.status(HttpStatus.CREATED).build();
			}
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	
	}

	@Override
	public void putData(Address address) {
		addressrepo.save(address);
		
	}

	@Override
	public void deleteAddressById(int id) {

		addressrepo.deleteById(id);
		
	}
}