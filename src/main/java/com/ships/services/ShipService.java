package com.ships.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.Ship;
import com.ships.repositories.ShipRepository;

@Service
public class ShipService {
	
	@Autowired
	private ShipRepository shipRepository;
	 
	public Ship saveShip(Ship ship) {
		return shipRepository.save(ship);
	}
		
	public List<Ship> findAll() {
		return (List<Ship>) shipRepository.findAll();
	};
	
	public List<Ship> findByShippingCompanyIsNull() {
		return (List<Ship>) shipRepository.findByShippingCompanyIsNull();
	}
}
