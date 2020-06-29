package org.codejudge.sb.model;

import javax.validation.constraints.NotNull;

public class ShareDriverLocationModel {

	@NotNull
	private Double latitude;
	@NotNull
	private Double longitude;

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

}
