package com.example.kommunevalgbackend.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="voter")
public class Voter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String choice;

    @OneToOne
    private Vote vote;


    public Voter(String choice, Vote vote){
        this.choice = choice;
        this.vote = vote;
    }

    public Voter(){

    }


    public Long getId(){
        return id;
    }

    public String getChoice(){
        return choice;
    }

    public void setChoice(String choice){
        this.choice = choice;
    }

    public Vote getVote(){
        return vote;
    }

    public void setVote(Vote vote){
        this.vote = vote;
    }
}
