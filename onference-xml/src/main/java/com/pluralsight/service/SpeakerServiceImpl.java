package com.pluralsight.service;

import com.pluralsight.model.Speaker;
import com.pluralsight.repository.SpeakerRepository;

import java.util.List;

public class SpeakerServiceImpl implements SpeakerService {

    SpeakerRepository repository ;

    //The default constructor in this case is not really required.
    //But incase if we are instantiating without arguments then this is required
    public SpeakerServiceImpl() {
    }

    public SpeakerServiceImpl(SpeakerRepository repository) {
        this.repository = repository;
    }



    public List<Speaker> findAll() {
        return repository.findAll();
    }

    //changed auto generated from setRepository to setSpeakerRepository to make auto-injection easy
    public void setSpeakerRepository(SpeakerRepository repository) {
        this.repository = repository;
    }

}
