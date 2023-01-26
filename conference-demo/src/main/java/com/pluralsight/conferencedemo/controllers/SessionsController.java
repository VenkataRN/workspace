package com.pluralsight.conferencedemo.controllers;

import com.pluralsight.conferencedemo.models.Session;
import com.pluralsight.conferencedemo.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {

    @Autowired
    private SessionRepository sessionRepository;

    //By default list() will be calaled for request mapping
    //springMVC pass the JPA result to Jackson which is serialization library
    //which converts that to JSON to return the same.
    @GetMapping
    public List<Session> list(){
        return sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    //Pathvariable marshals the incoming parameter value to  Long value
    //Auto marshalling the findById result to JSON
    public Session get(@PathVariable Long id) {
        return sessionRepository.findById(id).get();
    }

    @PostMapping
    //In general for post return will 200 OK.
    // if we want to customize to particular HTTP Response code
    //Then use ResponseStatus Annotation and associated value here i used 201.
    @ResponseStatus(HttpStatus.CREATED)
    //Spring MVC takes incoming Session JSON details Object and marshals to Session class
    public Session create(@RequestBody final Session session) {
        return sessionRepository.saveAndFlush(session);
    }

    @RequestMapping(value = "{id}", method=RequestMethod.DELETE)
    //This is to support REST DELETE Operation we have enforced Requestmethod.DELETE
    public void delete(@PathVariable Long id) {
        sessionRepository.deleteById(id);
    }

    @RequestMapping(value="{id}", method = RequestMethod.PUT)
    public void update(@PathVariable Long id, @RequestBody final Session session) {
        //This is PUT so, we are overwriting all the content, if no values then get updated with Null
        Session existingSession = sessionRepository.findById(id).get();
        BeanUtils.copyProperties(session, existingSession, "session_id");
        //Being session_id is a primary key, we are not replacing it. Third argument above is to skip

        sessionRepository.saveAndFlush(existingSession);
    }


}
