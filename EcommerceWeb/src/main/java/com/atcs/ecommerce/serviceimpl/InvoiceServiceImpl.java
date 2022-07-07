package com.atcs.ecommerce.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atcs.ecommerce.entity.Invoice;
import com.atcs.ecommerce.entity.Order;
import com.atcs.ecommerce.repo.OrderRepo;
import com.atcs.ecommerce.service.InvoiceService;


@Component
public class InvoiceServiceImpl implements InvoiceService
{

	
	@Autowired
	OrderRepo orderRepo;
		
	@Override
	public Invoice getInvoice(int orderid) {
		
		Order order = orderRepo.findById(orderid).get();
		double totalPrice = order.getTotalPrice();
		return new Invoice(order.getOrderItem(),totalPrice,order.getUser().getAddress());
	}

}
