package org.codejudge.sb.model;

import org.springframework.http.HttpStatus;

public class ApiErrorResponse {

	// http status code
	private HttpStatus httpstatus;
	private String status;
	private String reason;

	public static final class ApiErrorResponseBuilder {
		private HttpStatus httpstatus;
		private String status;
		private String reason;

		public ApiErrorResponseBuilder() {
		}

		public static ApiErrorResponseBuilder anApiErrorResponse() {
			return new ApiErrorResponseBuilder();
		}

		public ApiErrorResponseBuilder withStatus(HttpStatus httpstatus) {
			this.httpstatus = httpstatus;
			return this;
		}

		public ApiErrorResponseBuilder withError_code(String status) {
			this.status = status;
			return this;
		}

		public ApiErrorResponseBuilder withMessage(String reason) {
			this.reason = reason;
			return this;
		}

		public ApiErrorResponse build() {
			ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
			apiErrorResponse.httpstatus = this.httpstatus;
			apiErrorResponse.status = this.status;
			apiErrorResponse.reason = this.reason;
			return apiErrorResponse;
		}
	}
}
