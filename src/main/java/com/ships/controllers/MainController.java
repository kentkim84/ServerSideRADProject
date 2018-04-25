package com.ships.controllers;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
		// Get list of all ships that are not currently associated with any Shipping Company
		Map<Ship, String> shipList = new HashMap<Ship, String>();
		List<Ship> availableShipList = shipService.findByShippingCompanyIsNull();
		
		// Put ship and label to the ship list
		for (Ship ship : availableShipList) {
			String selectLabel = ship.getName() + "; Cost = " + ship.getCost();
			shipList.put(ship, selectLabel);
		}				
				
		// Get list of all Shipping companies
		Map<ShippingCompany, String> shippingCompanyList = new HashMap<ShippingCompany, String>();
		List<ShippingCompany> availableShippingCompanyList = shippingCompanyService.findAll();
		
		// Put shipping company and label to the shipping company list
		for (ShippingCompany shippingCompany : availableShippingCompanyList) {
			String selectLabel = shippingCompany.getName() + "; Balance = " + shippingCompany.getBalance();
			shippingCompanyList.put(shippingCompany, selectLabel);
		}		
		
		modelAndView.addObject("orderInfo", new OrderInfo());
		modelAndView.addObject("shipList", shipList);
		modelAndView.addObject("shippingCompanyList", shippingCompanyList);						
		modelAndView.setViewName("createOrder");
		
		return modelAndView;
	}
	
	// Add*** controllers with Post method	
	@Override
	@PostMapping("/addShip")
	public ModelAndView addShipPost(@Valid @ModelAttribute("ship") Ship ship, BindingResult bindingResult, ModelAndView modelAndView) {

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("addShip");
			return modelAndView;
		} else {
			shipService.saveShip(ship);
			return new ModelAndView("redirect:/showAllShipList");
		}			
	}

	@Override
	@PostMapping("/addShippingCompany")
	public ModelAndView addShippingCompanyPost(@Valid @ModelAttribute("shippingCompany") ShippingCompany shippingCompany, BindingResult bindingResult, ModelAndView modelAndView) {
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("addShippingCompany");
			return modelAndView;
		} else {
			shippingCompanyService.saveShippingCompany(shippingCompany);
			modelAndView.addObject("shippingCompany", new ShippingCompany());
			return new ModelAndView("redirect:/showAllShippingCompanyList");
		}
	}

	@Override
	@PostMapping("/createOrder")
	public ModelAndView createOrderInfoPost(@Valid @ModelAttribute("orderInfo") OrderInfo orderInfo, BindingResult bindingResult, ModelAndView modelAndView) {			
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("createOrder");
			return modelAndView;
		} else {			
			// If no Ship and/or Shipping Company is/are selected, it'll throw an exception
			if ( orderInfo.getShip() == null || orderInfo.getShippingCompany() == null) {
				modelAndView.addObject("errorMessage", new String("No Ship and/or Shipping Company selected"));
				modelAndView.setViewName("createOrderError");
				return modelAndView;
			}
			
			BigDecimal shipCost = orderInfo.getShip().getCost();
			BigDecimal shippingCompanyBalance = orderInfo.getShippingCompany().getBalance();
						
			// If Ship cost is greater than Shipping company balance, it'll throw an exception
			if (shipCost.compareTo(shippingCompanyBalance) == 1) {					
				modelAndView.addObject("errorMessage", new String("Shipping company balance is less than cost of ship - Cannot place order"));
				modelAndView.setViewName("createOrderError");
				return modelAndView;
			}
						
			orderInfoService.saveOrderInfo(orderInfo);
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
