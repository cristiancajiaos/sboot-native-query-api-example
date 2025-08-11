package com.example.sbootnativequeryapiexample.repository;

import com.example.sbootnativequeryapiexample.entity.Tutorial;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

  @Query(value = "SELECT * FROM tutorials", nativeQuery = true)
  List<Tutorial> getAllTutorials();

  @Query(value = "SELECT * FROM tutorials t WHERE t.id = ?1", nativeQuery = true)
  Tutorial getTutorialById(Long id);

  @Query(value = "SELECT * FROM tutorials t WHERE t.published = ?1", nativeQuery = true)
  List<Tutorial> getTutorialsByPublished(Boolean published);

  @Query(value = "SELECT * FROM tutorials t WHERE t.title LIKE %?1%", nativeQuery = true)
  List<Tutorial> getTutorialsByTitleLike(String title);

  @Query(value = "SELECT * FROM tutorials t WHERE LOWER(t.title) LIKE LOWER(CONCAT('%', ?1, '%'))", nativeQuery = true)
  List<Tutorial> getTutorialsByTitleCaseInsensitiveLike(String title);

}
