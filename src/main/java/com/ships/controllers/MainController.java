package com.ships.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ships.model.Ship;
import com.ships.model.ShippingCompany;
import com.ships.model.OrderInfo;
import com.ships.services.ShipService;
import com.ships.services.ShippingCompanyService;
import com.ships.services.OrderInfoService;

@Controller
public class MainController implements MainControllerInterface {
	@Autowired
	private ShipService shipService;
	@Autowired
	private ShippingCompanyService shippingCompanyService;
	@Autowired
	private OrderInfoService orderInfoService;
	
	@Override
	@RequestMapping(value = "/addShip", method = RequestMethod.GET)
	public void addShipGet(Ship ship) {
		
	}

	@Override
	@RequestMapping(value = "/addShippingCompany", method = RequestMethod.GET)
	public void addShippingCompanyGet(ShippingCompany shippingCompany) {
		
		
	}

	@Override
	@RequestMapping(value = "/addOrderInfo", method = RequestMethod.GET)
	public void addOrderInfoGet(OrderInfo orderInfo) {

		
	}
	
	@Override
	@RequestMapping(value = "/addShip", method = RequestMethod.POST)
	public void addShipPost(Ship ship) {

		
	}

	@Override
	@RequestMapping(value = "/addShippingCompany", method = RequestMethod.POST)
	public void addShippingCompanyPost(ShippingCompany shippingCompany) {

		
	}

	@Override
	@RequestMapping(value = "/addOrderInfo", method = RequestMethod.POST)
	public void addOrderInfoPost(OrderInfo orderInfo) {

		
	}

	@Override
	@RequestMapping(value = "/getAllShip", method = RequestMethod.GET)
	public List<Ship> getAllShip() {

		return null;
	}

	@Override
	@RequestMapping(value = "/getAllShippingCompany", method = RequestMethod.GET)
	public List<ShippingCompany> getAllShippingCompany() {

		return null;
	}

	@Override
	@RequestMapping(value = "/getAllOrderInfo", method = RequestMethod.GET)
	public List<OrderInfo> getAllOrderInfo() {

		return null;
	}

	
}
