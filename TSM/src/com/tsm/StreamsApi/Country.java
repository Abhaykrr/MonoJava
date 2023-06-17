package com.tsm.StreamsApi;


public class Country {
	
	private int regionId;
	private String countryCode;
	private String countryName;
	
	public Country(int regionId, String countryCode, String countryName) {
		super();
		this.regionId = regionId;
		this.countryCode = countryCode;
		this.countryName = countryName;
	}

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Override
	public String toString() {
		return "Country [regionId=" + regionId + ", countryCode=" + countryCode + ", countryName=" + countryName + "]";
	}
	
	
	
	

}

