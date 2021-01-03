package com.guitars.axe.guitars.service.impl;

import com.guitars.axe.guitars.entity.Guitar;
import com.guitars.axe.guitars.entity.GuitarVariant;
import com.guitars.axe.guitars.repository.GuitarRepository;
import com.guitars.axe.guitars.service.GuitarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GuitarServiceImpl implements GuitarService {

    private static final Logger logger = LoggerFactory.getLogger(GuitarServiceImpl.class);

    @Autowired
    GuitarRepository guitarRepository;

    @Override
    public Guitar addGuitar(Guitar guitar) {
//        logger.info("GuitarServiceImpl :: addPhones : Payload = {}", phone);
        List<GuitarVariant> guitarVariants = guitar.getGuitarVariants();
        guitarVariants.forEach(variant -> variant.setGuitar(guitar));
        return guitarRepository.save(guitar);
    }

    @Override
    public List<Guitar> getAllGuitars() {
        return StreamSupport.stream(guitarRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Guitar getGuitar(String guitarId) {
        return guitarRepository.findById(guitarId).orElseThrow(() -> new RuntimeException("Guitar not found"));
    }
}
