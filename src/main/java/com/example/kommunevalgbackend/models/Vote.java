package com.example.kommunevalgbackend.models;

import javax.persistence.*;

@Entity
@Table(name="vote")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String voteType;

    @Column
    private String vote;

    @Column
    private int totalVotes;



    public Vote(String voteType, String vote){
        this.voteType = voteType;
        this.vote = vote;

        totalVotes++;
    }


    public Vote(){
        totalVotes++;
    }


    public Long getId(){
        return id;
    }

    public String getVoteType(){
        return voteType;
    }

    public void setVoteType(String voteType){
        this.voteType = voteType;
    }

    public String getVote(){
        return vote;
    }

    public void setVote(String vote){
        this.vote = vote;
    }


    public int getVoteCount(){
        return totalVotes;
    }
}
