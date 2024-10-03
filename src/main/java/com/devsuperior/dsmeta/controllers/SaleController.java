package com.devsuperior.dsmeta.controllers;

import java.util.List;

import com.devsuperior.dsmeta.dto.SaleReportDTO;
import com.devsuperior.dsmeta.dto.SaleSummaryDTO;
import org.springdoc.core.PropertyResolverUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.projections.ReportProjection;
import com.devsuperior.dsmeta.projections.SummaryProjection;
import com.devsuperior.dsmeta.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;
    @Autowired
    private PropertyResolverUtils propertyResolverUtils;


	@GetMapping(value = "/{id}")
	public ResponseEntity<SaleMinDTO> findById(@PathVariable Long id) {
		SaleMinDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/report")
	public ResponseEntity<List<SaleReportDTO>> getReport(
			@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate,
			@RequestParam(value = "name", defaultValue = "") String name) {

		List<SaleReportDTO> result = service.searchReport(minDate, maxDate, name);

		return ResponseEntity.ok(result);
	}


	@GetMapping(value = "/summary")
	public ResponseEntity<List<SaleSummaryDTO>> getSummary(
			@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate) {

		List<SaleSummaryDTO> result = service.searchSummary(minDate, maxDate);

		// TODO
		return ResponseEntity.ok(result);
	}
}
