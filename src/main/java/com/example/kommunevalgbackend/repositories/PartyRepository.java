package com.example.kommunevalgbackend.repositories;

import com.example.kommunevalgbackend.models.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRepository extends JpaRepository<Party, Long> {
}
