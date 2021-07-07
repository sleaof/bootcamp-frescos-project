package com.mercadolibre.dambetan01.repository;

import com.mercadolibre.dambetan01.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
