package com.ships.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.OrderInfo;
import com.ships.repositories.OrderInfoRepository;

@Service
public class OrderInfoService {

	@Autowired
	private OrderInfoRepository orderInfoRepository;
	 
	public OrderInfo saveOrderInfo(OrderInfo orderInfo) {				
		return orderInfoRepository.save(orderInfo);
	}
		
	public List<OrderInfo> findAll() {
		return (List<OrderInfo>) orderInfoRepository.findAll();
	};
}
