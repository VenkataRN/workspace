package com.pluralsight.service;

import com.pluralsight.model.Speaker;
import com.pluralsight.repository.SpeakerRepository;

import java.util.List;

public class SpeakerServiceImpl implements SpeakerService {

    SpeakerRepository repository ;

    public List<Speaker> findAll() {
        return repository.findAll();
    }

    //changed auto generated from setRepository to setSpeakerRepository to make auto-injection easy
    public void setSpeakerRepository(SpeakerRepository repository) {
        this.repository = repository;
    }

}
