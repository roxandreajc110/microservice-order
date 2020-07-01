package com.hiberus.microservice.order.service;

import com.hiberus.microservice.order.models.entity.Order;
import com.hiberus.microservice.order.util.ResponseGenerics;

/**
 * Interface Service Order
 * 
 * @author Roxana Andrea Jaramillo Cobos
 * @version 0.0.1
 */

public interface IOrderService {

	/**
	 * Check out order
	 * 
	 * @param Order
	 * @return ResponseGenerics
	 */
	ResponseGenerics checkOut(Order order);

}
