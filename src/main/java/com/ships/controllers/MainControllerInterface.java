package com.ships.controllers;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.ships.model.OrderInfo;
import com.ships.model.Ship;
import com.ships.model.ShippingCompany;

public interface MainControllerInterface {
	/**
	 * Returns a ModelAndView object that can be added to a view
	 * and a model would be displayed.
	 * A Http request mapping annotation must be implemented. i.e. @RequestMapping with a GET method, or @GetMapping
	 * A 'path' for request mapping annotation should be specified. i.e. (path="/addShip"), (value="/addShip"), ("/addShip")
	 * @param modelAndView Holder for both Model and View in the web MVC framework.
	 * @return represents a model and view returned by a handler, to be resolved by a DispatcherServlet.
	 * @see addShip.html page with a form tag.
	 */		
	public ModelAndView addShipGet(ModelAndView modelAndView);
	/**
	 * Returns a ModelAndView object that can be added to a view
	 * and a model would be displayed.
	 * A Http request mapping annotation must be implemented. i.e. @RequestMapping with a GET method, or @GetMapping
	 * A 'path' for request mapping annotation should be specified. i.e. (path="/addShippingCompany"), (value="/addShippingCompany"), ("/addShippingCompany")
	 * @param modelAndView Holder for both Model and View in the web MVC framework.
	 * @return represents a model and view returned by a handler, to be resolved by a DispatcherServlet.
	 * @see addShippingCompany.html page with a form tag.
	 */
	public ModelAndView addShippingCompanyGet(ModelAndView modelAndView);
	/**
	 * Returns a ModelAndView object that can be added to a view
	 * and a model would be displayed.
	 * A Http request mapping annotation must be implemented. i.e. @RequestMapping with a GET method, or @GetMapping
	 * A 'path' for request mapping annotation should be specified. i.e. (path="/createOrder"), (value="/createOrder"), ("/createOrder")
	 * @param modelAndView Holder for both Model and View in the web MVC framework.
	 * @return represents a model and view returned by a handler, to be resolved by a DispatcherServlet.
	 * @see createOrder.html page with a form tag.
	 */
	public ModelAndView createOrderInfoGet(ModelAndView modelAndView);	
	/**
	 * Returns a ModelAndView object that can be added to a view
	 * and a model would be displayed.
	 * A Http request mapping annotation must be implemented. i.e. @RequestMapping with a POST method, or @PostMapping
	 * A 'path' for request mapping annotation should be specified. i.e. (path="/addShip"), (value="/addShip"), ("/addShip")
	 * @param modelAndView Holder for both Model and View in the web MVC framework. Create a new ModelAndView object with redirect keyword 
	 * to prevent any browser reload of the resulting page will not repeat the original request. i.e. ("redirect:/getAllShipList") 
	 * @param ship add an @ModelAttribute annotation to the method specifying a name with which to reference the object in the view. i.e. @ModelAttribute("ship")
	 * @param bindingResult as an argument for a validate method of a Validator inside a Controller.
	 * @return represents a model and view returned by a handler, to be resolved by a DispatcherServlet.
	 * @see addShip.html page with a form tag, after a submit button clicked with a fulfilled form, it will redirect to getAllShipList.html page
	 */
	public ModelAndView addShipPost(Ship ship, BindingResult bindingResult, ModelAndView modelAndView);
	/**
	 * Returns a ModelAndView object that can be added to a view
	 * and a model would be displayed.
	 * A Http request mapping annotation must be implemented. i.e. @RequestMapping with a POST method, or @PostMapping
	 * A 'path' for request mapping annotation should be specified. i.e. (path="/addShippingCompany"), (value="/addShippingCompany"), ("/addShippingCompany")
	 * @param modelAndView Holder for both Model and View in the web MVC framework. Create a new ModelAndView object with redirect keyword 
	 * to prevent any browser reload of the resulting page will not repeat the original request. i.e. ("redirect:/getAllShippingCompanyList") 
	 * @param shippingCompany add an @ModelAttribute annotation to the method specifying a name with which to reference the object in the view. i.e. @ModelAttribute("shippingCompany")
	 * @param bindingResult as an argument for a validate method of a Validator inside a Controller.
	 * @return represents a model and view returned by a handler, to be resolved by a DispatcherServlet.
	 * @see addShippingCompany.html page with a form tag, after a submit button clicked with a fulfilled form, it will redirect to getAllShippingCompanyList.html page
	 */
	public ModelAndView addShippingCompanyPost(ShippingCompany shippingCompany, BindingResult bindingResult, ModelAndView modelAndView);
	/**
	 * Returns a ModelAndView object that can be added to a view
	 * and a model would be displayed.
	 * A Http request mapping annotation must be implemented. i.e. @RequestMapping with a POST method, or @PostMapping
	 * A 'path' for request mapping annotation should be specified. i.e. (path="/createOrder"), (value="/createOrder"), ("/createOrder")
	 * @param modelAndView Holder for both Model and View in the web MVC framework. Create a new ModelAndView object with redirect keyword 
	 * to prevent any browser reload of the resulting page will not repeat the original request. i.e. ("redirect:/getAllShippingCompanyList") 
	 * @param orderInfo add an @ModelAttribute annotation to the method specifying a name with which to reference the object in the view. i.e. @ModelAttribute("orderInfo")
	 * @param bindingResult as an argument for a validate method of a Validator inside a Controller.
	 * @return represents a model and view returned by a handler, to be resolved by a DispatcherServlet.
	 * @see createOrder.html page with a form tag, after a submit button clicked with a fulfilled form, it will redirect to getAllOrderInfoList.html page
	 */
	public ModelAndView createOrderInfoPost(OrderInfo orderInfo, BindingResult bindingResult, ModelAndView modelAndView);
	/**
	 * Returns a ModelAndView object that can be added to a view
	 * and a model would be displayed.
	 * A Http request mapping annotation must be implemented. i.e. @RequestMapping with a GET method, or @GetMapping
	 * A 'path' for request mapping annotation should be specified. i.e. (path="/getAllShipList"), (value="/getAllShipList"), ("/getAllShipList")
	 * @param modelAndView Holder for both Model and View in the web MVC framework.  
	 * @return represents a model and view returned by a handler, to be resolved by a DispatcherServlet.
	 * @see getAllShipList.html page with a table tag.
	 */
	public ModelAndView getAllShipList(ModelAndView modelAndView);
	/**
	 * Returns a ModelAndView object that can be added to a view
	 * and a model would be displayed.
	 * A Http request mapping annotation must be implemented. i.e. @RequestMapping with a GET method, or @GetMapping
	 * A 'path' for request mapping annotation should be specified. i.e. (path="/getAllShippingCompanyList"), (value="/getAllShippingCompanyList"), ("/getAllShippingCompanyList")
	 * @param modelAndView Holder for both Model and View in the web MVC framework.  
	 * @return represents a model and view returned by a handler, to be resolved by a DispatcherServlet.
	 * @see getAllShippingCompanyList.html page with a table tag.
	 */
	public ModelAndView getAllShippingCompanyList(ModelAndView modelAndView);
	/**
	 * Returns a ModelAndView object that can be added to a view
	 * and a model would be displayed.
	 * A Http request mapping annotation must be implemented. i.e. @RequestMapping with a GET method, or @GetMapping
	 * A 'path' for request mapping annotation should be specified. i.e. (path="/getAllOrderInfoList"), (value="/getAllOrderInfoList"), ("/getAllOrderInfoList")
	 * @param modelAndView Holder for both Model and View in the web MVC framework.  
	 * @return represents a model and view returned by a handler, to be resolved by a DispatcherServlet.
	 * @see getAllOrderInfoList.html page with a table tag.
	 */
	public ModelAndView getAllOrderInfoList(ModelAndView modelAndView);	
}
