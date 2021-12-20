package com.example.kommunevalgbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="party")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String partyName;

    @Column(nullable = true)
    private int votes;

    @OneToMany(mappedBy = "partyName")
    @JsonManagedReference
    private List<Candidate> candidates;


    /*public Party(String partyName, List<Candidate> candidates){
        this.partyName = partyName;
        this.candidates = candidates;
    }
*/

    public Party(String partyName){
        this.partyName = partyName;
    }

    public Party(){

    }


    public Long getId(){
        return id;
    }

    public String getPartyName(){
        return partyName;
    }

    public void setPartyName(String partyName){
        this.partyName = partyName;
    }

    public List<Candidate> getCandidates(){
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates){
        this.candidates = candidates;
    }

    public int getVotes(){
        return votes;
    }

    public void setVotes(int votes){
        this.votes = votes;
    }


    public void addVote(int number){
        votes += number;
    }

    public void addCandidateToParty(Candidate candidate){
        candidates.add(candidate);
    }
}
