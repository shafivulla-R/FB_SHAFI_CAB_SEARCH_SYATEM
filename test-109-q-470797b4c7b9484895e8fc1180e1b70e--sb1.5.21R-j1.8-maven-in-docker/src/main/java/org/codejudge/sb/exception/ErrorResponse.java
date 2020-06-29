package org.codejudge.sb.exception;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("error")
public class ErrorResponse {
	public ErrorResponse(String status, String reason) {
		super();
		this.status = status;
		this.reason = reason;
	}

	private String status;
	private String reason;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}