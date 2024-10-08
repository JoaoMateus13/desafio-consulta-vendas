package com.devsuperior.dsmeta.repositories;


import com.devsuperior.dsmeta.dto.SaleReportDTO;
import com.devsuperior.dsmeta.dto.SaleSummaryDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {


    @Query("SELECT new com.devsuperior.dsmeta.dto.SaleSummaryDTO(obj.seller.name, SUM(obj.amount)) " +
            "FROM Sale obj " +
            "WHERE obj.date BETWEEN :minDate AND :maxDate " +
            "GROUP BY obj.seller.name")
    //@Query("SELECT obj FROM Sale obj JOIN FETCH obj.seller")
    List<SaleSummaryDTO> searchSummary(@Param("minDate") LocalDate minDate,
                                       @Param("maxDate") LocalDate maxDate);


    @Query("SELECT new com.devsuperior.dsmeta.dto.SaleReportDTO(obj.id, obj.date, obj.amount, obj.seller.name) " +
            "FROM Sale obj " +
            "WHERE (obj.date BETWEEN :minDate and :maxDate) AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%',:name,'%')) ")
    List<SaleReportDTO> searchReport(@Param("minDate") LocalDate minDate,
                                     @Param("maxDate") LocalDate maxDate,
                                     @Param("name") String name);


}
