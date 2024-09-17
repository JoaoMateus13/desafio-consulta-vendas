package com.devsuperior.dsmeta.projections;

import java.time.LocalDate;

import com.devsuperior.dsmeta.entities.Seller;

public interface ReportProjection {
    
    Long getId();
    LocalDate getDate();
    Double getAmount();
    Seller getSeller_name();
}
