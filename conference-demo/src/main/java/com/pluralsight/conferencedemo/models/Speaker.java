package com.pluralsight.conferencedemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity(name="speakers")
public class Speaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long speaker_id;

    private String first_name;
    private String last_name;
    private String title;
    private String company;
    private String speaker_bio;

    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    //without above annotation gets exception by jpa.
    private byte[] speaker_photo;

    public byte[] getSpeaker_photo() {
        return speaker_photo;
    }

    public void setSpeaker_photo(byte[] speaker_photo) {
        this.speaker_photo = speaker_photo;
    }

    //Please observe that mappedBy is given speakers.
    // Because in Session.java the variable name is speakers
    @ManyToMany(mappedBy = "speakers")
    //Below JsonIgnore is to fix Serialization Problem
    //In Session.java we declared manytomany
    //So, when we query all... then it tries
    //get the session and list speakers..but each speaker again has session..
    //so lists sessions...and so on.. will go to infinite

    //To avoid we used @JsonIgnore
    //Because Session.java has dominant side of bi-directional (means there main join is declared)
    // so, here we are adding JsonIgnore
    // This comes from Jackson.. it ignores while reload the session
    @JsonIgnore
    private List<Session> sessions;

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public Speaker() {};

    public long getSpeaker_id() {
        return speaker_id;
    }

    public void setSpeaker_id(long speaker_id) {
        this.speaker_id = speaker_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSpeaker_bio() {
        return speaker_bio;
    }

    public void setSpeaker_bio(String speaker_bio) {
        this.speaker_bio = speaker_bio;
    }

}
