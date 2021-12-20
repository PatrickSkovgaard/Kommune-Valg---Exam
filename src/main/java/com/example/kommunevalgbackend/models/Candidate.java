package com.example.kommunevalgbackend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="candidate")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn //Nødvendig???
    @JsonBackReference
    private Party party;

    @Column
    private int votes;


    public Candidate(String name, Party party){
        this.name = name;
        this.party = party;
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

    public Party getParty(){
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
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
