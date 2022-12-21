package com.pluralsight.service;

import com.pluralsight.model.Speaker;
import com.pluralsight.repository.HibernateSpeakerRepositoryImpl;
import com.pluralsight.repository.SpeakerRepository;

import java.util.List;

public class SpeakerServiceImpl implements SpeakerService {

    //SpeakerRepository hibernateSpeakerRepository = new HibernateSpeakerRepositoryImpl();
    private SpeakerRepository speakerRepository;

    @Override
    public List<Speaker> findAll() {
        return speakerRepository.findAll();
    }


    public void setSpeakerRepository(SpeakerRepository speakerRepository) {
        this.speakerRepository = speakerRepository;
    }
}
