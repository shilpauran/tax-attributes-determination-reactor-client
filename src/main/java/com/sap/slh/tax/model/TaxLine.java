package com.sap.slh.tax.model;

import java.io.Serializable;
import java.math.BigDecimal;


public class TaxLine implements Serializable{
	

    /**
	 * 
	 */
	private static final long serialVersionUID = -3388246831559747770L;
	private String id;
    private String taxTypeCode;
    private BigDecimal taxRate;
    private BigDecimal nonDeductibleTaxRate;
    private String dueCategoryCode;
    private Boolean isTaxDeferred;
    private Boolean isReverseChargeRelevant;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaxTypeCode() {
        return taxTypeCode;
    }

    public void setTaxTypeCode(String taxType) {
        this.taxTypeCode = taxType;
    }

    public String getDueCategoryCode() {
        return dueCategoryCode;
    }

    public void setDueCategoryCode(String dueCategory) {
        this.dueCategoryCode = dueCategory;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getNonDeductibleTaxRate() {
        return nonDeductibleTaxRate;
    }

    public void setNonDeductibleTaxRate(BigDecimal taxDeductibilityRate) {
        this.nonDeductibleTaxRate = taxDeductibilityRate;
    }

    public Boolean getIsTaxDeferred() {
        return isTaxDeferred;
    }

    public void setIsTaxDeferred(Boolean isTaxDeferred) {
        this.isTaxDeferred = isTaxDeferred;
    }
    
    public Boolean getIsReverseChargeRelevant() {
		return isReverseChargeRelevant;
	}

	public void setIsReverseChargeRelevant(Boolean isReverseChargeRelevant) {
		this.isReverseChargeRelevant = isReverseChargeRelevant;
	}

}
