package com.mercadolibre.dambetan01.service.crud.impl;

import com.mercadolibre.dambetan01.dtos.BatchHasPurchaseOrderDTO;
import com.mercadolibre.dambetan01.model.BatchHasPurchaseOrder;
import com.mercadolibre.dambetan01.repository.BatchHasPurchaseOrderRepository;
import com.mercadolibre.dambetan01.service.crud.IBatchHasPurchaseOrder;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
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
        batchHasPurchaseOrderRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Não foi encontrado nenhum registro com este Id: " + id));

        batchHasPurchaseOrderRepository.deleteById(id);
    }

    @Override
    public BatchHasPurchaseOrderDTO findById(Long id) {
        BatchHasPurchaseOrder batchHasPurchaseOrder = batchHasPurchaseOrderRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Não foi encontrado nenhum registro com este Id: " + id));

        return modelMapper.map(batchHasPurchaseOrder, BatchHasPurchaseOrderDTO.class);
    }

    @Override
    public List<BatchHasPurchaseOrderDTO> findAll() {
        return batchHasPurchaseOrderRepository.findAll()
                .stream()
                .map(batchPO -> modelMapper.map(batchPO, BatchHasPurchaseOrderDTO.class))
                .collect(Collectors.toList());
    }
}
