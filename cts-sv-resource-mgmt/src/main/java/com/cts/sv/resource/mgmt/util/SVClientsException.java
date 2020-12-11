package com.cts.sv.resource.mgmt.util;

import java.util.Date;

public class SVClientsException extends Exception {
	
	Date timestamp;
	String message;
	String description;
	
	public SVClientsException(Date timestamp, String message, String description) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.description = description;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDescription() {
		return description;
	}	
	
	

}
