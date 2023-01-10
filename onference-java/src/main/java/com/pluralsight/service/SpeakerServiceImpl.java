package com.pluralsight.service;

import com.pluralsight.model.Speaker;
import com.pluralsight.repository.HibernateSpeakerRepositoryImpl;
import com.pluralsight.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("SpeakerService")
public class SpeakerServiceImpl implements SpeakerService {

    //SpeakerRepository hibernateSpeakerRepository = new HibernateSpeakerRepositoryImpl();
    @Autowired
    private SpeakerRepository speakerRepository;

    public SpeakerServiceImpl(SpeakerRepository repository) {
        speakerRepository = repository;
    }
    @Override
    public List<Speaker> findAll() {
        return speakerRepository.findAll();
    }


    public void setSpeakerRepository(SpeakerRepository speakerRepository) {
        this.speakerRepository = speakerRepository;
    }
}
