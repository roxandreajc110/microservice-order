package com.hiberus.microservice.order.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hiberus.microservice.order.util.Constants;

import io.swagger.annotations.ApiModelProperty;

/**
 * Business entity Order.
 * 
 * @author Roxana Andrea Jaramillo Cobos
 * @version 0.0.1
 */
@Entity
@Table(name = "\"order\"")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id", nullable = false, length = 10)
	@ApiModelProperty(value = "Order Identifier", name = "id", dataType = "Long", example = "strategy = GenerationType.IDENTITY")
	private Long id;

	@NotNull(message = "Identification client " + Constants.MSN_VALID_NULL)
	@Column(nullable = false, length = 10)
	@ApiModelProperty(value = "Identification client", name = "identification", dataType = "Long", example = "101845955")
	private Long identification;

	/**
	 * Order customer Relationship N-1
	 */
	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false, insertable = true, updatable = false)
	private Customer customer;

	@NotBlank(message = "Delivery Address" + Constants.MSN_VALID_NULL)
	@Size(max = 150, message = Constants.MSN_VALID_LENGTH + " 150 characters.")
	@Column(nullable = false, length = 150)
	@ApiModelProperty(value = "Delivery Address", name = "identification", dataType = "String", example = "Kr 110 Barrio La Perla")
	private String deliveryAddress;

	@ApiModelProperty(value = "Order total", name = "total", dataType = "Long", example = "250000")
	@Column(nullable = false)
	private Long total;

	@Column(name = "creation_date", nullable = false, insertable = true, updatable = false)
	@ApiModelProperty(value = "Order date", name = "creationDate", dataType = "Date", example = "12-04-2020")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "COT")
	private Date creationDate;

	/**
	 * List of orders details, Relationship 1-N
	 */
	@NotNull(message = "List Orders details " + Constants.MSN_VALID_NULL)
	@Valid
	@OneToMany(mappedBy = "order")
	private List<OrderDetail> listOrdersDetails;

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
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the deliveryAddress
	 */
	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	/**
	 * @param deliveryAddress the deliveryAddress to set
	 */
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	/**
	 * @return the total
	 */
	public Long getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Long total) {
		this.total = total;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the listOrdersDetails
	 */
	public List<OrderDetail> getListOrdersDetails() {
		return listOrdersDetails;
	}

	/**
	 * @param listOrdersDetails the listOrdersDetails to set
	 */
	public void setListOrdersDetails(List<OrderDetail> listOrdersDetails) {
		this.listOrdersDetails = listOrdersDetails;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
