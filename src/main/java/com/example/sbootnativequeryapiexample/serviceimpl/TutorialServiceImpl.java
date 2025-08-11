package com.example.sbootnativequeryapiexample.serviceimpl;

import com.example.sbootnativequeryapiexample.entity.Tutorial;
import com.example.sbootnativequeryapiexample.record.TutorialDTO;
import com.example.sbootnativequeryapiexample.repository.TutorialRepository;
import com.example.sbootnativequeryapiexample.service.TutorialService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorialServiceImpl implements TutorialService {

  @Autowired
  private TutorialRepository tutorialRepository;

  public TutorialServiceImpl(
      TutorialRepository tutorialRepository) {
    this.tutorialRepository = tutorialRepository;
  }

  @Override
  public List<TutorialDTO> getAllTutorials() {
    return tutorialRepository.getAllTutorials().stream().map(this::convertToDTO).collect(Collectors.toList());
  }

  @Override
  public TutorialDTO getTutorialById(Long id) {
    Tutorial foundTutorial = tutorialRepository.getTutorialById(id);
    return convertToDTO(foundTutorial);
  }

  @Override
  public List<TutorialDTO> getTutorialsByPublished(Boolean published) {
    return tutorialRepository.getTutorialsByPublished(published).stream().map(this::convertToDTO).collect(
        Collectors.toList());
  }

  @Override
  public List<TutorialDTO> getTutorialsByTitleLike(String title) {
    return tutorialRepository.getTutorialsByTitleLike(title).stream().map(this::convertToDTO).collect(
        Collectors.toList());
  }

  @Override
  public List<TutorialDTO> getTutorialsByTitleCaseInsensitiveLike(String title) {
    return tutorialRepository.getTutorialsByTitleCaseInsensitiveLike(title).stream().map(this::convertToDTO).collect(
        Collectors.toList());
  }


  private Tutorial convertToEntity(TutorialDTO tutorialDTO) {
    return new Tutorial(tutorialDTO.id(), tutorialDTO.title(), tutorialDTO.description(), tutorialDTO.level(),
        tutorialDTO.published());
  }

  private TutorialDTO convertToDTO(Tutorial tutorial) {
    return new TutorialDTO(tutorial.getId(), tutorial.getTitle(), tutorial.getDescription(), tutorial.getLevel(), tutorial.isPublished());
  }
}
