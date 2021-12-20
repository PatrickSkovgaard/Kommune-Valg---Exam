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


    @GetMapping("/view_candidate/{id}")
    public ResponseEntity<Optional<Candidate>> viewOneCandidate(@PathVariable(name = "id") Long id){

        Optional<Candidate> candidate = candidateRepository.findById(id);

        if(candidate.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(candidate);
        }
        else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/view_all_candidates")
    public ResponseEntity<List<Candidate>> viewAllCandidates(){

        List<Candidate> candidates = candidateRepository.findAll();

        if(!candidates.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(candidates);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/add_candidate")
    public ResponseEntity<Candidate> addCandidate(){

        Candidate candidate = new Candidate();
        candidateRepository.save(candidate);

        return ResponseEntity.status(HttpStatus.CREATED).body(candidate);
    }

    @PutMapping("/edit_candidate/{id}")
    public ResponseEntity<Candidate> editCandidate(@PathVariable(name = "id") Long id){

        Optional<Candidate> candidate = candidateRepository.findById(id);

        if(candidate.isPresent()){
            candidateRepository.save(candidate.get());
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

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
