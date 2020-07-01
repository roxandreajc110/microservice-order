package com.hiberus.microservice.order.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.hiberus.microservice.order.util.Constants;

import io.swagger.annotations.ApiModelProperty;

/**
 * Business entity OrderDetail.
 * 
 * @author Roxana Andrea Jaramillo Cobos
 * @version 0.0.1
 */
@Entity
@Table(name = "order_detail")
public class OrderDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_detail_id", nullable = false, length = 10)
	@ApiModelProperty(value = "OrderDetail Identifier", name = "id", dataType = "Long", example = "strategy = GenerationType.IDENTITY")
	private Long id;

	@NotNull(message = "Id sold product " + Constants.MSN_VALID_NULL)
	@Column(nullable = false, length = 10)
	@ApiModelProperty(value = "Id sold product", name = "productId", dataType = "Long", example = "1201")
	private Long productId;

	@NotNull(message = "Quantity sold of the product " + Constants.MSN_VALID_NULL)
	@Column(nullable = false)
	@ApiModelProperty(value = "Quantity sold of the product", name = "quantity", dataType = "Integer", example = "25")
	private Integer quantity;

	@Column(nullable = false, length = 15)
	@ApiModelProperty(value = "Total price of products", name = "total", dataType = "Long", example = "25000")
	private Long total;
	
	/**
	 * Order Relationship N-1
	 */
	@ManyToOne
	@JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false, insertable = true, updatable = false)
	private Order order;

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
	 * @return the productId
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
