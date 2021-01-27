package com.vik.embeddable;

public class Address {
	private Long countryId;
	private Long stateId;
	private Long cityId;
	private Long pincode;
	private String addressLine1;

	public Long getCountryId() {
		return countryId;
	}

	public Long getStateId() {
		return stateId;
	}

	public Long getCityId() {
		return cityId;
	}

	public Long getPincode() {
		return pincode;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

}
