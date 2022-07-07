package com.atcs.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atcs.ecommerce.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>  {

}