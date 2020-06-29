package org.codejudge.sb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "bad request")
public class RegisterDriverBadRequestException extends RuntimeException {

	public RegisterDriverBadRequestException(String exception) {
		super(exception);
	}

}
