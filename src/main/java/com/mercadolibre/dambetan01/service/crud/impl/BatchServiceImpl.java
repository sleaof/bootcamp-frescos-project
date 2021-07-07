package com.mercadolibre.dambetan01.service.crud.impl;

import com.mercadolibre.dambetan01.dtos.BatchDTO;
import com.mercadolibre.dambetan01.mapper.BatchMapper;
import com.mercadolibre.dambetan01.model.Batch;
import com.mercadolibre.dambetan01.model.Product;
import com.mercadolibre.dambetan01.repository.BatchRepository;
import com.mercadolibre.dambetan01.service.crud.IBatchService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BatchServiceImpl implements IBatchService {

    private BatchRepository batchRepository;

    private ModelMapper modelMapper;

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
        Optional<Batch> opt = batchRepository.findById(id);
        if (!opt.isPresent()) {
            throw new NoSuchElementException("There is no Batch with this Id: " + id);
        }
        batchRepository.deleteById(id);
    }

    @Override
    public BatchDTO findById(Long id) {
        Optional<Batch> opt = batchRepository.findById(id);

        if (!opt.isPresent()) {
            throw new NoSuchElementException("There is no Batch with this Id: " + id);
        }
        return modelMapper.map(opt.get(), BatchDTO.class);
    }

    @Override
    public List<BatchDTO> findAll() {
        List<BatchDTO> batchDTO = batchRepository.findAll()
                .stream()
                .map(batch -> modelMapper.map(batch, BatchDTO.class))
                .collect(Collectors.toList());
        return batchDTO;
    }
}