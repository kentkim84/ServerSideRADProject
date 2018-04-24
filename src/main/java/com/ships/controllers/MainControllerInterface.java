package com.ships.controllers;

import org.springframework.validation.BindingResult;
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
	public ModelAndView addShipPost(Ship ship, BindingResult bindingResult, ModelAndView modelAndView);
	public ModelAndView addShippingCompanyPost(ShippingCompany shippingCompany, BindingResult bindingResult, ModelAndView modelAndView);
	public ModelAndView createOrderInfoPost(OrderInfo orderInfo, BindingResult bindingResult, ModelAndView modelAndView);
	
	// getAll*** methods
	public ModelAndView getAllShipList(ModelAndView modelAndView);
	public ModelAndView getAllShippingCompanyList(ModelAndView modelAndView);
	public ModelAndView getAllOrderInfoList(ModelAndView modelAndView);	
}
