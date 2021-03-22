package com.po;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import java.util.Date;

public class Products {
    @JsonProperty("products_id")
    private Integer productsId;

    @JsonProperty("income_price")
    private Double incomePrice;

    @JsonProperty("income_date")
    private Date incomeDate;

    @JsonProperty("name")
    private String name;

    public Integer getProductsId() {
        return productsId;
    }

    public void setProductsId(Integer productsId) {
        this.productsId = productsId;
    }

    public Double getIncomePrice() {
        return incomePrice;
    }

    public void setIncomePrice(Double incomePrice) {
        this.incomePrice = incomePrice;
    }

    public Date getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(Date incomeDate) {
        this.incomeDate = incomeDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}