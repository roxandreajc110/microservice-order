package com.hiberus.microservice.order.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hiberus.microservice.order.models.entity.Order;
import com.hiberus.microservice.order.util.ResponseGenerics;

import io.swagger.annotations.ApiOperation;

/**
 * Enpoint REST Order
 *
 * @author Roxana Andrea Jaramillo Cobos
 * @version 0.0.1
 */
@CrossOrigin("*")
@RequestMapping("/order")
public interface OrderApi {

	/**
	 * Process Check out process
	 * 
	 * @RequestBody Order
	 * @return ResponseGenerics
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/checkOut", produces = "application/json; charset=UTF-8")
	@ApiOperation(value = "Check out", notes = "Process Check out process")
	ResponseGenerics checkOut(@Valid @RequestBody Order order);

}