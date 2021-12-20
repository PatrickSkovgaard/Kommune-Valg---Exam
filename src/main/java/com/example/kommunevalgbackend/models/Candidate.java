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

    @Column
    private String name;

    @Column()
    private String partyName;

    @Column
    private int votes;


    public Candidate(String name, String partyName){
        this.name = name;
        this.partyName = partyName;
    }

    public Candidate(String name){
        this.name = name;
    }

    public Candidate(){

    }


    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
