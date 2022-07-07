package com.atcs.ecommerce.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.atcs.ecommerce.entity.Cart;
import com.atcs.ecommerce.entity.OrderItem;
import com.atcs.ecommerce.entity.Product;
import com.atcs.ecommerce.repo.CartRepo;
import com.atcs.ecommerce.repo.OrderRepo;
import com.atcs.ecommerce.repo.ProductRepo;
import com.atcs.ecommerce.repo.UserRepo;
import com.atcs.ecommerce.service.CartService;

@Component
public class CartServiceImpl implements CartService{

	
	public final CartRepo cartRepo;
	
	public final OrderRepo orderRepo;
	
	public final UserRepo userRepo;
	
	@Autowired
	ProductRepo productRepo;
	
	
	
	public CartServiceImpl(CartRepo cartRepo, OrderRepo orderRepo, UserRepo userRepo) {
		super();
		this.cartRepo = cartRepo;
		this.orderRepo = orderRepo;
		this.userRepo = userRepo;
	}
	@Override
	public List<Cart> getData() {
		
		return cartRepo.findAll();
	}
	@Override
	public Cart getDataById(int id) {
		
		return cartRepo.findById(id).get();
	}

	@Override
	public void postData(Cart car) {
		cartRepo.save(car);
	}

	@Override
	public void putData(Cart car) {
		cartRepo.save(car);
		
	}

	@Override
	public void deleteData(int id) {
		cartRepo.deleteById(id);
		
	}
	@Override
	public ResponseEntity<String> addToCart(int id,int id1) {
		Product pro = productRepo.findById(id).get();
		
		OrderItem orderItem = new OrderItem(1, pro.getPrice(), pro);
		
		Cart cart = cartRepo.findById(id1).get();
		
		if(cart.getOrderItem().size()<5) {
		cart.getOrderItem().add(orderItem);
		cartRepo.save(cart);
		return ResponseEntity.status(HttpStatus.OK).build();
		}
		else 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@Override
	public void removeToCart(int proid, int cartid) {
		// TODO Auto-generated method stub
		
		
		Cart cart = cartRepo.findById(cartid).get();
		
		List<OrderItem> orderItem = cart.getOrderItem();
		
		int rm =0;
		for(int i=0;i<orderItem.size();i++)
		{
			if(orderItem.get(i).getProduct().getId()==proid)
			{
				rm=i;
				break;
			}
		}
		orderItem.remove(rm);
			
		cartRepo.save(cart);
		
	}

}
