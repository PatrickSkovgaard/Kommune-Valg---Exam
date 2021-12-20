package com.example.kommunevalgbackend.repositories;

import com.example.kommunevalgbackend.models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    public List<Candidate> getCandidatesByPartyName(String partyName);
}
