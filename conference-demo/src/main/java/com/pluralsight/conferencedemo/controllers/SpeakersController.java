package com.pluralsight.conferencedemo.controllers;

import com.pluralsight.conferencedemo.models.Session;
import com.pluralsight.conferencedemo.models.Speaker;
import com.pluralsight.conferencedemo.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {

    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speaker> list() {
        return speakerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id) {
        return speakerRepository.findById(id).get();
    }

    @PostMapping
    //In general for post return will 200 OK.
    // if we want to customize to particular HTTP Response code
    //Then use ResponseStatus Annotation and associated value here i used 201.
    @ResponseStatus(HttpStatus.CREATED)
    //Spring MVC takes incoming Session JSON details Object and marshals to Session class
    public Speaker create(@RequestBody final Speaker session) {
        return speakerRepository.saveAndFlush(session);
    }

    @RequestMapping(value = "{id}", method=RequestMethod.DELETE)
    //This is to support REST DELETE Operation we have enforced Requestmethod.DELETE
    public void delete(@PathVariable Long id) {
        speakerRepository.deleteById(id);
    }

    @RequestMapping(value="{id}", method = RequestMethod.PUT)
    public void update(@PathVariable Long id, @RequestBody final Speaker speaker) {
        //This is PUT so, we are overwriting all the content, if no values then get updated with Null
        Speaker existingSpeaker = speakerRepository.findById(id).get();
        BeanUtils.copyProperties(speaker, existingSpeaker, "session_id");
        //Being session_id is a primary key, we are not replacing it. Third argument above is to skip

        speakerRepository.saveAndFlush(existingSpeaker);
    }
}
