package com.pluralsight.repository;

import com.pluralsight.model.Speaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class HibernateSpeakerRepositoryImpl implements SpeakerRepository {

    @Autowired
    private Calendar cal;

    //Below value is caliculated in runtime and gets added to the seedNum
    @Value("#{ T(java.lang.Math).random() * 100}")
    private double seedNum;

    @Override
    public List<Speaker> findAll() {
        List<Speaker> speakers = new ArrayList<>();

        Speaker speaker = new Speaker();
        speaker.setFirstName("Venkat");
        speaker.setLastName("RN");
        speaker.setSeedNum(seedNum);

        System.out.println("Cal : " + cal.getTime());
        speakers.add(speaker);
        return speakers;
    }
}
