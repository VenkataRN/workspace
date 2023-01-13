package com.pluralsight.service;

import com.pluralsight.model.Speaker;
import com.pluralsight.repository.HibernateSpeakerRepositoryImpl;
import com.pluralsight.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
@Service("SpeakerService")
public class SpeakerServiceImpl implements SpeakerService {

    //SpeakerRepository hibernateSpeakerRepository = new HibernateSpeakerRepositoryImpl();
    @Autowired
    private SpeakerRepository speakerRepository;

    public SpeakerServiceImpl() {
        System.out.println("No-Args Constrcutor injection");
    }
    public SpeakerServiceImpl(SpeakerRepository repository) {
        System.out.println("Constrcutor injection");
        speakerRepository = repository;
    }
    @Override
    public List<Speaker> findAll() {
        return speakerRepository.findAll();
    }

    @PostConstruct
    private void intialize(){
        System.out.println("Postconstrcut annotation initialize");
    }
    public void setSpeakerRepository(SpeakerRepository speakerRepository) {
        this.speakerRepository = speakerRepository;
    }
}
