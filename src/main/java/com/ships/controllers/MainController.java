package com.ships.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

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
	@GetMapping("/addShip")
	public ModelAndView addShipGet(Ship ship, ModelAndView modelAndView) {		
		modelAndView.setViewName("addShip");
		return modelAndView;
	}

	@Override
	@GetMapping("/addShippingCompany")
	public ModelAndView addShippingCompanyGet(ShippingCompany shippingCompany, ModelAndView modelAndView) {
		modelAndView.setViewName("addShippingCompany");
		return modelAndView;
	}

	@Override
	@GetMapping("/createOrder")
	public ModelAndView createOrderInfoGet(OrderInfo orderInfo, ModelAndView modelAndView) {
		modelAndView.setViewName("createOrder");
		return modelAndView;
	}
	
	@Override
	@PostMapping("/addShip")
	public ModelAndView addShipPost(Ship ship, ModelAndView modelAndView) {

		return null;
	}

	@Override
	@PostMapping("/addShippingCompany")
	public ModelAndView addShippingCompanyPost(ShippingCompany shippingCompany, ModelAndView modelAndView) {

		return null;
	}

	@Override
	@PostMapping("/createOrder")
	public ModelAndView createOrderInfoPost(OrderInfo orderInfo, ModelAndView modelAndView) {

		return null;
	}

	@Override
	@GetMapping("/showAllShipList")
	public ModelAndView getAllShipList(ModelAndView modelAndView) {		
		modelAndView.addObject("shipList", shipService.findAll());
		modelAndView.setViewName("showAllShipList");
		return modelAndView;
	}

	@Override
	@GetMapping("/showAllShippingCompanyList")
	public ModelAndView getAllShippingCompanyList(ModelAndView modelAndView) {
		modelAndView.addObject("shippingCompanyList", shippingCompanyService.findAll());
		modelAndView.setViewName("showAllShippingCompanyList");
		return modelAndView;
	}

	@Override
	@GetMapping("/showAllOrderInfoList")
	public ModelAndView getAllOrderInfoList(ModelAndView modelAndView) {
		modelAndView.addObject("orderInfoList", orderInfoService.findAll());
		modelAndView.setViewName("showAllOrderInfoList");
		return modelAndView;
	}

	
}
