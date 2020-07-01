package com.hiberus.microservice.order.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hiberus.microservice.order.models.entity.Order;
import com.hiberus.microservice.order.models.repository.CustomerRepository;
import com.hiberus.microservice.order.util.ResponseGenerics;

/**
 * Interface Implementation Order
 * 
 * @author Roxana Andrea Jaramillo Cobos
 * @version 0.0.1
 */
@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private RestTemplate clientRest;

	private final CustomerRepository customerRepository;

	protected Logger logger = LogManager.getLogger(OrderServiceImpl.class);

	@Autowired
	public OrderServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public ResponseGenerics checkOut(Order order) {
		ResponseGenerics response;
		boolean existClient = false;
		try {

			/* 1. Check if user customer */
			existClient = customerRepository.existsByIdentification(order.getIdentification());
			if (existClient) {
				/* 2. Call service to generate bill */
				response = generateBill(order);
				if (response != null && response.getStatus().equals("200 OK")) {
					long idOrder = ((Number) response.getData().get("idOrder")).longValue();
					/* 3. Call service to generate bill */
					response = generateShippingOrder(idOrder);
					return response;
				} else {
					return response;
				}
			} else {
				return new ResponseGenerics(HttpStatus.NOT_FOUND.toString(),
						"The client does not exist,please register", null);
			}
		} catch (Exception e) {
			logger.error("ERROR: " + Thread.currentThread().getStackTrace()[1].getMethodName() + e.getMessage());
			return new ResponseGenerics(HttpStatus.INTERNAL_SERVER_ERROR.toString(),
					"The operation could not be completed, contact your administrator", null);
		}
	}

	/* Method that calls the microservice to generate invoice */
	private ResponseGenerics generateBill(Order order) {
		ResponseEntity<ResponseGenerics> response = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			HttpHeaders requestHeaders = new HttpHeaders();
			requestHeaders.setContentType(new MediaType("application", "json"));
			HttpEntity<Order> request = new HttpEntity<>(order, requestHeaders);
			response = clientRest.exchange("http://localhost:8083/bill/generate", HttpMethod.POST, request,
					ResponseGenerics.class);
		} catch (Exception e) {
			return new ResponseGenerics(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Internal Error", null);
		}
		return response.getBody();
	}
	
	/* Method that calls the microservice to generate shipping order */
	private ResponseGenerics generateShippingOrder(long idOrder) {
		ResponseEntity<ResponseGenerics> response = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			HttpHeaders requestHeaders = new HttpHeaders();
			requestHeaders.setContentType(new MediaType("application", "json"));
			HttpEntity<Order> request = new HttpEntity<>(null, requestHeaders);
			response = clientRest.exchange("http://localhost:8085/logistic/generateShippingOrder/"+idOrder, HttpMethod.POST, request,
					ResponseGenerics.class);
		} catch (Exception e) {
			return new ResponseGenerics(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Internal Error", null);
		}
		return response.getBody();
	}

}
