package com.example.kommunevalgbackend.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="candidate")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(length = 3)
    private String partyName;

    @Column
    private int votes;


    public Candidate(String fullName, String partyName){
        this.fullName = fullName;
        this.partyName = partyName;
    }

    public Candidate(String fullName){
        this.fullName = fullName;
    }

    public Candidate(){

    }


    public Long getId(){
        return id;
    }

    public String getFullName(){
        return fullName;
    }

    public void setFullName(String name) {
        this.fullName = name;
    }

    public String getParty(){
        return partyName;
    }

    public void setParty(String partyName) {
        this.partyName = partyName;
    }

    public int getVotes(){
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }


    public void addVote(int number){
        votes += number;
    }
}
