package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.projections.SummaryProjection;

public class SaleSummaryDTO{

    private String sallerName;
    private Double sum;

    public SaleSummaryDTO(String sallerName, Double sum) {
        this.sallerName = sallerName;
        this.sum = sum;
    }


    public SaleSummaryDTO() {
    }

    public SaleSummaryDTO(SummaryProjection projection) {
        sallerName = projection.getSellerName();
        sum = projection.getSum();
    }


    public String getSallerName() {
        return sallerName;
    }

    public Double getSum() {
        return sum;
    }
}
