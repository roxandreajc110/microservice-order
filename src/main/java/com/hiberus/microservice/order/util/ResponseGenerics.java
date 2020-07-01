package com.hiberus.microservice.order.util;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;

/**
 * Generic response message.
 * 
 * @author Roxana Andrea Jaramillo Cobos
 */
@JsonInclude(Include.NON_NULL)
public class ResponseGenerics implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "Response Status", name = "status", dataType = "String", example = "200")
	private String status;

	@ApiModelProperty(value = "Response Message", name = "message", dataType = "String", example = "Successful process")
	private String message;

	@ApiModelProperty(value = "Response data", name = "data", dataType = "Map<String, Object>")
	private Map<String, Object> data;

	public ResponseGenerics() {
	}

	public ResponseGenerics(String status) {
		this.status = status;
		this.message = null;
	}

	public ResponseGenerics(String status, String message, Map<String, Object> data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the data
	 */
	public Map<String, Object> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Map<String, Object> data) {
		this.data = data;
	}

}