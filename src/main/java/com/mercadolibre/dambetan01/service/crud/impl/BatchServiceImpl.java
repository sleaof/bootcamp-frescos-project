package com.mercadolibre.dambetan01.service.crud.impl;

import com.mercadolibre.dambetan01.dtos.BatchDTO;
import com.mercadolibre.dambetan01.dtos.response.BatchResponseDTO;
import com.mercadolibre.dambetan01.model.Batch;
import com.mercadolibre.dambetan01.repository.BatchRepository;
import com.mercadolibre.dambetan01.service.crud.IBatchService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class BatchServiceImpl implements IBatchService {

    private final BatchRepository batchRepository;

    private final ModelMapper modelMapper;

    public BatchServiceImpl(BatchRepository batchRepository, ModelMapper modelMapper) {
        this.batchRepository = batchRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public BatchDTO create(BatchDTO batchDTO) {
        Batch batch = modelMapper.map(batchDTO, Batch.class);
        batchRepository.save(batch);
        return batchDTO;
    }

    @Override
    public BatchDTO update(BatchDTO batchDTO) {
        Batch batch = batchRepository.findById(batchDTO.getBatchNumber()).orElseThrow();
        batchRepository.save(batch);
        return batchDTO;
    }

    @Override
    public void delete(Long id) {
        batchRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Não foi encontrado nenhum estoque com este Id: " + id));

        batchRepository.deleteById(id);
    }

    @Override
    public BatchDTO findById(Long id) {
        Batch batch = batchRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Não foi encontrado nenhum estoque com este Id: " + id));

        return modelMapper.map(batch, BatchDTO.class);
    }

    @Override
    public List<BatchDTO> findAll() {
        return batchRepository.findAll()
                .stream()
                .map(batch -> modelMapper.map(batch, BatchDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BatchResponseDTO> getAllBatchesOffAWarehouseByDueDate(Integer days) {
        System.out.println(batchRepository.findAllBatchesOffAWarehouseByDueDate(days));
        return batchRepository.findAllBatchesOffAWarehouseByDueDate(days)
                .stream()
                .map(batch -> modelMapper.map(batch, BatchResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BatchResponseDTO> getAllBatchesSortedByDueDateAndCategory(Integer days, String category) {
        return batchRepository.findAllBatchesSortedByDueDateAndCategory(days, category)
                .stream()
                .map(batch -> modelMapper.map(batch, BatchResponseDTO.class))
                .collect(Collectors.toList());
    }
}
