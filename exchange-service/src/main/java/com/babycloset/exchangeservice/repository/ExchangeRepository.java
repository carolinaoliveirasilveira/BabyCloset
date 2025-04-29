package com.babycloset.exchangeservice.repository;

import com.babycloset.exchangeservice.entity.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRepository extends JpaRepository<Exchange, Long> {
}
