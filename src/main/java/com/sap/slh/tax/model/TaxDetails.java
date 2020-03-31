package com.sap.slh.tax.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class TaxDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5623440171012699512L;
	
	@JsonProperty("taxableCountry")
	private String taxableCountry;
	@JsonProperty("taxEventCode")
	private String taxEventCode;
	
	@JsonProperty("taxableCountry")
	public String getTaxableCountry() {
		return taxableCountry;
	}
	@JsonProperty("taxableCountry")
	public void setTaxableCountry(String taxableCountry) {
		this.taxableCountry = taxableCountry;
	}

	@JsonProperty("taxEventCode")
	public String getTaxEventCode() {
		return taxEventCode;
	}

	@JsonProperty("taxEventCode")
	public void setTaxEventCode(String taxEventCode) {
		this.taxEventCode = taxEventCode;
	}

}
