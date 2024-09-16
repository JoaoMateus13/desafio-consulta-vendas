package com.devsuperior.dsmeta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.devsuperior.dsmeta.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {
    
}
