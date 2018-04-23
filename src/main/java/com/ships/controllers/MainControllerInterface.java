package com.ships.controllers;

import java.util.List;

import com.ships.model.OrderInfo;
import com.ships.model.Ship;
import com.ships.model.ShippingCompany;

public interface MainControllerInterface {
	// add*** Get methods
	public void addShipGet(Ship ship);
	public void addShippingCompanyGet(ShippingCompany shippingCompany);
	public void addOrderInfoGet(OrderInfo orderInfo);
	
	// add*** Post methods
	public void addShipPost(Ship ship);
	public void addShippingCompanyPost(ShippingCompany shippingCompany);
	public void addOrderInfoPost(OrderInfo orderInfo);
	
	// getAll*** methods
	public List<Ship> getAllShip();
	public List<ShippingCompany> getAllShippingCompany();
	public List<OrderInfo> getAllOrderInfo();	
}
