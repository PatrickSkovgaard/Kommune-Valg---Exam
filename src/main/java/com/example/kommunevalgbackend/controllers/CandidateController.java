package com.example.kommunevalgbackend.controllers;

import com.example.kommunevalgbackend.models.Candidate;
import com.example.kommunevalgbackend.repositories.CandidateRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class CandidateController {

    private CandidateRepository candidateRepository;

    public CandidateController(CandidateRepository candidateRepository){
        this.candidateRepository = candidateRepository;
    }


    //Ekstra til opgave 2
    @GetMapping("/view_candidate/{id}")
    public ResponseEntity<Optional<Candidate>> viewOneCandidate(@PathVariable(name = "id") Long id){

        Optional<Candidate> candidate = candidateRepository.findById(id);

        if(candidate.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(candidate);
        }
        else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(candidate);
        }
    }


    //Opgave 2.b
    @GetMapping("/view_all_candidates")
    public ResponseEntity<List<Candidate>> viewAllCandidates(){

        List<Candidate> candidates = candidateRepository.findAll();

        if(!candidates.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(candidates);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(candidates);
        }
    }


    //Opgave 2.c
    @GetMapping("/view_candidates_by_party/{party_name}")
    public ResponseEntity<List<Candidate>> viewCandidatesByParty(@PathVariable(name = "party_name")
                                                                 String partyName){

        List<Candidate> candidates = candidateRepository.getCandidatesByPartyName(partyName);

        if(!candidates.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(candidates);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(candidates);
        }
    }


    //Opgave 2.a
    @PostMapping("/add_candidate/{name}")
    public ResponseEntity<Candidate> addCandidate(@PathVariable(name = "name") String name){
        Candidate candidate = new Candidate(name);
        candidateRepository.save(candidate);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    //Opgave 2.a
    @PutMapping("/add_party_to_candidate/{id}/{party_name}")
    public ResponseEntity<Candidate> addPartyToCandidate(@PathVariable(name = "id") Long id,
                                                         @PathVariable(name = "party_name")
                                                         String partyName){

        Candidate candidate = candidateRepository.getById(id);
        candidate.setParty(partyName);

        candidateRepository.save(candidate);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    //Opgave 2.a
    @PutMapping("/edit_candidate/{id}/{new_name}")
    public ResponseEntity<Candidate> editCandidate(@PathVariable(name = "id") Long id,
                                                   @PathVariable(name= "new_name") String newName){

        Optional<Candidate> candidate = candidateRepository.findById(id);

        if(candidate.isPresent()){
            candidate.get().setName(newName);
            candidateRepository.save(candidate.get());
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    //Opgave 2.a
    @DeleteMapping("/delete_candidate/{id}")
    public ResponseEntity<Candidate> deleteCandidate(@PathVariable(name = "id") Long id){

        Optional<Candidate> candidate = candidateRepository.findById(id);

        if(candidate.isPresent()){
            candidateRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
}
