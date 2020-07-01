package com.hiberus.microservice.order.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.hiberus.microservice.order.util.Constants;

/**
 * Business entity Customer.
 * 
 * @author Roxana Andrea Jaramillo Cobos
 * @version 0.0.1
 */
@Entity
@Table
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Customer Identifier
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id", nullable = false, length = 10)
	private Long id;

	/**
	 * Type of customer identification
	 */
	@Size(max = 2, message = Constants.MSN_VALID_LENGTH + " 2 characters.")
	@Column(nullable = false, length = 2)
	private String typeIdentification;

	/**
	 * Customer identification
	 */
	@Column(nullable = false, length = 15)
	private Long identification;

	/**
	 * Customer Name
	 */
	@Size(max = 60, message = Constants.MSN_VALID_LENGTH + " 60 characters.")
	@Column(nullable = false, length = 191)
	private String name;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the typeIdentification
	 */
	public String getTypeIdentification() {
		return typeIdentification;
	}

	/**
	 * @param typeIdentification the typeIdentification to set
	 */
	public void setTypeIdentification(String typeIdentification) {
		this.typeIdentification = typeIdentification;
	}

	/**
	 * @return the identification
	 */
	public Long getIdentification() {
		return identification;
	}

	/**
	 * @param identification the identification to set
	 */
	public void setIdentification(Long identification) {
		this.identification = identification;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
