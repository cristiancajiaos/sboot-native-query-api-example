package com.example.sbootnativequeryapiexample.controller;

import com.example.sbootnativequeryapiexample.record.TutorialDTO;
import com.example.sbootnativequeryapiexample.service.TutorialService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
}
