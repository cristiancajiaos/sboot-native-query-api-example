package com.example.sbootnativequeryapiexample.repository;

import com.example.sbootnativequeryapiexample.entity.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

}
