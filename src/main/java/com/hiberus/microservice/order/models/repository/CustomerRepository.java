package com.hiberus.microservice.order.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.hiberus.microservice.order.models.entity.Customer;

/**
 * Interface DAO extends of CrudRepository
 * 
 * @author Roxana Andrea Jaramillo Cobos
 * @version 0.0.1
 */

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	boolean existsByIdentification(Long identification);
}