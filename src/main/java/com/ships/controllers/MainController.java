package com.ships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	
	// Add*** controllers with Get method
	@Override
	@GetMapping("/addShip")
	public ModelAndView addShipGet(ModelAndView modelAndView) {
		modelAndView.addObject("ship", new Ship());
		modelAndView.setViewName("addShip");
		return modelAndView;
	}

	@Override
	@GetMapping("/addShippingCompany")
	public ModelAndView addShippingCompanyGet(ModelAndView modelAndView) {
		modelAndView.addObject("shippingCompany", new ShippingCompany());
		modelAndView.setViewName("addShippingCompany");
		return modelAndView;
	}

	@Override
	@GetMapping("/createOrder")
	public ModelAndView createOrderInfoGet(ModelAndView modelAndView) {
		modelAndView.addObject("orderInfo", new OrderInfo());
		modelAndView.setViewName("createOrder");
		return modelAndView;
	}
	
	// Add*** controllers with Post method	
	@Override
	@PostMapping("/addShip")
	public ModelAndView addShipPost(@Valid Ship ship, BindingResult bindingResult, ModelAndView modelAndView) {				
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("addShip");
			return modelAndView;
		} else {
			shipService.saveShip(ship);
			/*modelAndView.addObject("SuccessMessage", "Ship has been added successfully");
			modelAndView.addObject("ship", new Ship());
			modelAndView.setViewName("showAllShipList");*/
			return new ModelAndView("redirect:/showAllShipList");
		}			
	}

	@Override
	@PostMapping("/addShippingCompany")
	public ModelAndView addShippingCompanyPost(@Valid ShippingCompany shippingCompany, BindingResult bindingResult, ModelAndView modelAndView) {
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("addShippingCompany");
			return modelAndView;
		} else {
			shippingCompanyService.saveShippingCompany(shippingCompany);
			/*modelAndView.addObject("SuccessMessage", "Shipping Company has been added successfully");
			modelAndView.addObject("shippingCompany", new ShippingCompany());
			modelAndView.setViewName("showAllShippingCompanyList");*/
			return new ModelAndView("redirect:/showAllShippingCompanyList");
		}
	}

	@Override
	@PostMapping("/createOrder")
	public ModelAndView createOrderInfoPost(@Valid OrderInfo orderInfo, BindingResult bindingResult, ModelAndView modelAndView) {
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("createOrder");
			return modelAndView;
		} else {
			orderInfoService.saveOrderInfo(orderInfo);
			/*modelAndView.addObject("SuccessMessage", "Order Info has been created successfully");
			modelAndView.addObject("orderInfo", new OrderInfo());
			modelAndView.setViewName("showAllOrderInfoList");*/
			return new ModelAndView("redirect:/showAllOrderInfoList");
		}
	}

	// Show*** controllers with Get method
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
