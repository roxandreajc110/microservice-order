package com.hiberus.microservice.order.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.hiberus.microservice.order.models.entity.Order;
import com.hiberus.microservice.order.service.IOrderService;
import com.hiberus.microservice.order.util.ResponseGenerics;

/**
 * Controller REST Order
 *
 * @author Roxana Andrea Jaramillo Cobos
 */

@RestController
public class OrderApiController implements OrderApi {

	private IOrderService orderService;

	@Autowired
	public OrderApiController(final IOrderService orderService) {
		this.orderService = orderService;
	}

	@Override
	public ResponseGenerics checkOut(Order order) {
		return orderService.checkOut(order);
	}
}