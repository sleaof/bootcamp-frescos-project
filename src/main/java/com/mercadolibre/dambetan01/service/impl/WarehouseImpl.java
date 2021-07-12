package com.mercadolibre.dambetan01.service.impl;

import com.mercadolibre.dambetan01.exceptions.NotFoundException;
import com.mercadolibre.dambetan01.model.Warehouse;
import com.mercadolibre.dambetan01.repository.WarehouseRepository;
import com.mercadolibre.dambetan01.service.WarehouseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class WarehouseImpl implements WarehouseService {

    private final WarehouseRepository warehouseRepository;

    @Override
    public Warehouse findById(Long id) {
        return warehouseRepository.findById(id).orElseThrow(() -> new NotFoundException("Warehouse " + id));
    }
}
