package com.ships.controllers;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.ships.model.OrderInfo;
import com.ships.model.Ship;
import com.ships.model.ShippingCompany;

public interface MainControllerInterface {
	// add*** Get methods
	public ModelAndView addShipGet(ModelAndView modelAndView);
	public ModelAndView addShippingCompanyGet(ModelAndView modelAndView);
	public ModelAndView createOrderInfoGet(ModelAndView modelAndView);
	
	// add*** Post methods
	public ModelAndView addShipPost(Ship ship, ModelAndView modelAndView);
	public ModelAndView addShippingCompanyPost(ShippingCompany shippingCompany, ModelAndView modelAndView);
	public ModelAndView createOrderInfoPost(OrderInfo orderInfo, ModelAndView modelAndView);
	
	// getAll*** methods
	public ModelAndView getAllShipList(ModelAndView modelAndView);
	public ModelAndView getAllShippingCompanyList(ModelAndView modelAndView);
	public ModelAndView getAllOrderInfoList(ModelAndView modelAndView);	
}
