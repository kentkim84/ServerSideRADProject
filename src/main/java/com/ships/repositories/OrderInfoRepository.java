package com.ships.repositories;

import com.ships.model.OrderInfo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderInfoRepository extends CrudRepository<OrderInfo, Integer> {
	// Basic queries provided
	// save(entity): save an Iterable of entities. Here, we can pass multiple objects to save them in a batch
	// findAll(): get an Iterable of all available entities in database
}
