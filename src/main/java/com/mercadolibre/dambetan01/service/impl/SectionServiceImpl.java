package com.mercadolibre.dambetan01.service.impl;

import com.mercadolibre.dambetan01.model.Section;
import com.mercadolibre.dambetan01.repository.SectionRepository;
import com.mercadolibre.dambetan01.service.SectionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SectionServiceImpl implements SectionService {

    private final SectionRepository sectionRepository;

    @Override
    public Section findById(Long id) {
        return sectionRepository.findById(id).orElseThrow();
    }
}
