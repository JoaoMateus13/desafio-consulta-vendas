package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import com.devsuperior.dsmeta.dto.SaleReportDTO;
import com.devsuperior.dsmeta.dto.SaleSummaryDTO;
import com.devsuperior.dsmeta.projections.SummaryProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}


	public List<SaleSummaryDTO> searchSummary(String minDate, String maxDate) {

		if (Objects.equals(maxDate, "")) {

			LocalDate max = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

			if(Objects.equals(minDate, "")) {

				LocalDate min = max.minusYears(1L);

				List<SaleSummaryDTO> dtos = repository.searchSummary(min, max);

				return dtos;

			}

			LocalDate min = LocalDate.parse(minDate);
			List<SaleSummaryDTO> dtos = repository.searchSummary(min, max);
			return dtos;


		}else {

			LocalDate min = LocalDate.parse(minDate);
			LocalDate max = LocalDate.parse(maxDate);

			List<SaleSummaryDTO> dtos = repository.searchSummary(min, max);

			return dtos;

		}

}

	public List<SaleReportDTO> searchReport(String minDate, String maxDate, String name) {

		if (Objects.equals(maxDate, "")) {

			LocalDate max = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

			if(Objects.equals(minDate, "")) {

				LocalDate min = max.minusYears(1L);

				List<SaleReportDTO> dtos = repository.searchReport(min, max, name);

				return dtos;

			}

			LocalDate min = LocalDate.parse(minDate);
			List<SaleReportDTO> dtos = repository.searchReport(min, max, name);
			return dtos;


		}else {

			LocalDate min = LocalDate.parse(minDate);
			LocalDate max = LocalDate.parse(maxDate);

			List<SaleReportDTO> dtos = repository.searchReport(min, max, name);

			return dtos;

		}

	}





	
}
