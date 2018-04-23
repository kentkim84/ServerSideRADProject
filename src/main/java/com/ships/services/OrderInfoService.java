package com.ships.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.OrderInfo;
import com.ships.repositories.OrderInfoRepository;

@Service
public class OrderInfoService {

	@Autowired
	private OrderInfoRepository orderInfoRepository;
	 
	public void saveShippingCompany(OrderInfo shippingCompany) {
		orderInfoRepository.save(shippingCompany);
	}
		
	public List<OrderInfo> findAll() {			
		return (List<OrderInfo>) orderInfoRepository.findAll();
	};
}
