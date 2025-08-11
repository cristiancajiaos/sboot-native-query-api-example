package com.example.sbootnativequeryapiexample.service;

import com.example.sbootnativequeryapiexample.record.TutorialDTO;
import java.util.List;

public interface TutorialService {

  List<TutorialDTO> getAllTutorials();

  TutorialDTO getTutorialById(Long id);

  List<TutorialDTO> getTutorialsByPublished(Boolean published);

  List<TutorialDTO> getTutorialsByTitleLike(String title);

  List<TutorialDTO> getTutorialsByTitleCaseInsensitiveLike(String title);
}
