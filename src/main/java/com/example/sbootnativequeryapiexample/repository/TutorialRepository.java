package com.example.sbootnativequeryapiexample.repository;

import com.example.sbootnativequeryapiexample.entity.Tutorial;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

  @Query(value = "SELECT * FROM tutorials", nativeQuery = true)
  List<Tutorial> getAllTutorials();

}
