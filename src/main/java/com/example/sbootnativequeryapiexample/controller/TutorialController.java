package com.example.sbootnativequeryapiexample.controller;

import com.example.sbootnativequeryapiexample.record.TutorialDTO;
import com.example.sbootnativequeryapiexample.service.TutorialService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/tutorials")
public class TutorialController {

  @Autowired
  private TutorialService tutorialService;

  public TutorialController(
      TutorialService tutorialService) {
    this.tutorialService = tutorialService;
  }

  @GetMapping
  public List<TutorialDTO> getAllTutorials() {
    return tutorialService.getAllTutorials();
  }

  @GetMapping("/{id}")
  public ResponseEntity<TutorialDTO> getTutorialById(@PathVariable Long id) {
    try {
      TutorialDTO foundTutorial = tutorialService.getTutorialById(id);
      return ResponseEntity.ok(foundTutorial);
    } catch (Exception ex) {
      System.err.println("Error: " + ex);
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("/published/{published}")
  public List<TutorialDTO> getTutorialsByPublished(@PathVariable Boolean published) {
    return tutorialService.getTutorialsByPublished(published);
  }

  @GetMapping("/title-like/{title}")
  public List<TutorialDTO> getTutorialsByTitleLike(@PathVariable String title) {
    return tutorialService.getTutorialsByTitleLike(title);
  }
}
