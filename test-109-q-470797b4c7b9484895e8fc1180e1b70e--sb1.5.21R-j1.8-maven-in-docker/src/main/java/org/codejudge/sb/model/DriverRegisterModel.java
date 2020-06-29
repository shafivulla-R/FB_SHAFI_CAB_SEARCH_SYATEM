package org.codejudge.sb.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "email", "phone_number", "license_number", "car_number" })
public class DriverRegisterModel {

	@NotEmpty(message = "name must not be empty")
	@JsonProperty("name")
	@NotBlank
	@Column(unique=true)
	@Size(min=2, max=30)
	private String name;
	@JsonProperty("email")
	@NotEmpty(message = "email must not be empty")
	@Email(message = "email should be a valid email")
	private String email;
	@NotNull
	//@Size(min=0,max=10)
	@JsonProperty("phone_number")
	private Long phoneNumber;
	@JsonProperty("license_number")
	@NotEmpty(message = "licenseNumber must not be empty")
	private String licenseNumber;
	@JsonProperty("car_number")
	@NotEmpty(message = "carnumber must not be empty")
	private String carNumber;

	@JsonProperty("id")
	private Integer id;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty("phone_number")
	public Long getPhoneNumber() {
		return phoneNumber;
	}

	@JsonProperty("phone_number")
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@JsonProperty("license_number")
	public String getLicenseNumber() {
		return licenseNumber;
	}

	@JsonProperty("license_number")
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	@JsonProperty("car_number")
	public String getCarNumber() {
		return carNumber;
	}

	@JsonProperty("car_number")
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@Override
	public String toString() {
		return "DriverRegisterModel [name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", licenseNumber=" + licenseNumber + ", carNumber=" + carNumber + ", id=" + id
				+ ", additionalProperties=" + additionalProperties + "]";
	}

}