package com.ships.services;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.OrderInfo;
import com.ships.repositories.OrderInfoRepository;

@Service
public class OrderInfoService {

	@Autowired
	private OrderInfoRepository orderInfoRepository;
	@Autowired
	private ShippingCompanyService shippingCompanyService;
	@Autowired
	private ShipService shipService; 
	 
	public OrderInfo saveOrderInfo(OrderInfo orderInfo) throws Exception {
		// Error Conditions:		
		// If no Ship and/or Shipping Company is/are selected, it'll throw an exception
		if (orderInfo.getShip() == null || orderInfo.getShippingCompany() == null) {			
			throw new Exception("No Ship and/or Shipping Company selected");
		}
				
		BigDecimal shipCost = orderInfo.getShip().getCost();
		BigDecimal shippingCompanyBalance = orderInfo.getShippingCompany().getBalance();
		
		// If Ship cost is greater than Shipping company balance, it'll throw an exception
		if (shipCost.compareTo(shippingCompanyBalance) == 1) {					
			throw new Exception("Shipping company balance is less than cost of ship - Cannot place order");
		}
						
		// Business Logic for Order Creation		
		BigDecimal newShippingCompanyBalance;
		
		// Update new shipping company balance and save/update this shipping company
		newShippingCompanyBalance = shippingCompanyBalance.subtract(shipCost);
		orderInfo.getShippingCompany().setBalance(newShippingCompanyBalance);
		shippingCompanyService.saveShippingCompany(orderInfo.getShippingCompany());
		
		// Save/update this shipping company to this ship
		orderInfo.getShip().setShippingCompany(orderInfo.getShippingCompany());
		shipService.saveShip(orderInfo.getShip());
		
		// Set the current time before save
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		orderInfo.setDate(df.format(cal.getTime()));
				
		return orderInfoRepository.save(orderInfo);
	}
		
	public List<OrderInfo> findAll() {
		return (List<OrderInfo>) orderInfoRepository.findAll();
	};
}
