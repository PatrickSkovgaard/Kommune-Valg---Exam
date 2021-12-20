package com.example.kommunevalgbackend.models;
/*
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="votebox")
public class Votebox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Vote> votes;

    @Column
    private int voteCount;


    public Votebox(){

    }


    public Long getId(){
        return id;
    }

    public List<Vote> getVotes(){
        return votes;
    }


    public void addVoteToVoteBox(Vote vote){
        votes.add(vote);
    }

    public int getVoteCount(){
        if(votes.size() == 0){
            voteCount = 0;
            return voteCount;
        }
        else {
            return votes.size();
        }
    }
}*/
