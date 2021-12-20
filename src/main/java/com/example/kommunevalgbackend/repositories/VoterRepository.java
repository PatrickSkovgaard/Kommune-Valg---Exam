package com.example.kommunevalgbackend.repositories;

import com.example.kommunevalgbackend.models.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoterRepository extends JpaRepository<Voter, Long> {
}
