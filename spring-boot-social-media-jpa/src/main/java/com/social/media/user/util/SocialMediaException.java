package com.social.media.user.util;

import java.util.Date;

public class SocialMediaException extends Exception {
	
	Date timestamp;
	String message;
	String description;
	
	public SocialMediaException(Date timestamp, String message, String description) {
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
