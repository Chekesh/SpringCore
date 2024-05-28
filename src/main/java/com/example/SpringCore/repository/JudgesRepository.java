package com.example.SpringCore.repository;

import com.example.SpringCore.entity.Judges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JudgesRepository extends JpaRepository<Judges, Long> {
}
