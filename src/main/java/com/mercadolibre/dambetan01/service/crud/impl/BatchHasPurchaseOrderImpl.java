package com.mercadolibre.dambetan01.service.crud.impl;

import com.mercadolibre.dambetan01.dtos.BatchHasPurchaseOrderDTO;
import com.mercadolibre.dambetan01.model.BatchHasPurchaseOrder;
import com.mercadolibre.dambetan01.repository.BatchHasPurchaseOrderRepository;
import com.mercadolibre.dambetan01.service.crud.IBatchHasPurchaseOrder;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BatchHasPurchaseOrderImpl implements IBatchHasPurchaseOrder {

    private final BatchHasPurchaseOrderRepository batchHasPurchaseOrderRepository;

    private final ModelMapper modelMapper;

    public BatchHasPurchaseOrderImpl(BatchHasPurchaseOrderRepository batchHasPurchaseOrderRepository,
                                     ModelMapper modelMapper) {
        this.batchHasPurchaseOrderRepository = batchHasPurchaseOrderRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public BatchHasPurchaseOrderDTO create(BatchHasPurchaseOrderDTO batchHasPurchaseOrderDTO) {
        BatchHasPurchaseOrder batchHasPurchaseOrder = modelMapper.map(batchHasPurchaseOrderDTO, BatchHasPurchaseOrder.class);
        batchHasPurchaseOrderRepository.save(batchHasPurchaseOrder);
        return batchHasPurchaseOrderDTO;
    }

    @Override
    public BatchHasPurchaseOrderDTO update(BatchHasPurchaseOrderDTO batchHasPurchaseOrderDTO) {
        BatchHasPurchaseOrder batchHasPurchaseOrder = modelMapper.map(batchHasPurchaseOrderDTO, BatchHasPurchaseOrder.class);
        batchHasPurchaseOrderRepository.save(batchHasPurchaseOrder);
        return batchHasPurchaseOrderDTO;
    }

    @Override
    public void delete(Long id) {
        Optional<BatchHasPurchaseOrder> opt = batchHasPurchaseOrderRepository.findById(id);
        if (opt.isEmpty()) {
            throw new NoSuchElementException("There is no Batch Has Purchase Order with this Id: " + id);
        }
        batchHasPurchaseOrderRepository.deleteById(id);
    }

    @Override
    public BatchHasPurchaseOrderDTO findById(Long id) {
        Optional<BatchHasPurchaseOrder> opt = batchHasPurchaseOrderRepository.findById(id);
        if (opt.isEmpty()) {
            throw new NoSuchElementException("There is no Batch Has Purchase Order with this Id: " + id);
        }
        return modelMapper.map(opt.get(), BatchHasPurchaseOrderDTO.class);
    }

    @Override
    public List<BatchHasPurchaseOrderDTO> findAll() {
        return batchHasPurchaseOrderRepository.findAll()
                .stream()
                .map(batchPO -> modelMapper.map(batchPO, BatchHasPurchaseOrderDTO.class))
                .collect(Collectors.toList());
    }
}
