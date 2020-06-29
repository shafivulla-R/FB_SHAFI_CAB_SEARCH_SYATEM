package org.codejudge.sb.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "message" })
public class AvailableCabsMessage {

	@JsonProperty("message")
	private String message;

	@JsonProperty("message")
	public String getMessage() {
		return message;
	}

	@JsonProperty("message")
	public void setmessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "AvailableCabsMessage [message=" + message + "]";
	}

}
