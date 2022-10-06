package org.aibles.animal.service.impl;


import java.util.List;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.aibles.animal.dto.request.CreateAnimalRequest;
import org.aibles.animal.dto.request.ListAnimalRequest;
import org.aibles.animal.dto.request.UpdateAnimalRequest;
import org.aibles.animal.dto.response.AnimalResponse;
import org.aibles.animal.entity.Animal;
import org.aibles.animal.exception.ResourceNotFoundException;
import org.aibles.animal.repository.AnimalRepository;
import org.aibles.animal.service.AnimalService;

@Slf4j
public class AnimalServiceImpl implements AnimalService {

  public final AnimalRepository repository;

  public AnimalServiceImpl(AnimalRepository repository) {
    this.repository = repository;
  }

  /**
   * Create animal to the list animal
   *
   * @param request
   * @return Animal
   */
  @Override
  @Transactional
  public AnimalResponse created(CreateAnimalRequest request) {
    log.info("(Created)animal: {}", request.getName());
    Animal animal = request.toAnimal();
    animal = repository.save(animal);
    AnimalResponse animalResponse = AnimalResponse.from(animal);
    return animalResponse;
  }

  /**
   * Get a list of animals
   *
   * @param listAnimalRequest
   * @return list animal
   */
  @Override
  @Transactional
  public List<Animal> list(ListAnimalRequest listAnimalRequest) {
    log.info("(List)Animal list: {}", listAnimalRequest.toString());
    return repository.findAll();
  }

  /**
   * Update information animal by id
   *
   * @param id
   * @param updateAnimalRequest
   * @return update
   */
  @Override
  @Transactional
  public AnimalResponse update_by_id(long id, UpdateAnimalRequest updateAnimalRequest) {
    log.info("(Update)Animal update by id: {}", updateAnimalRequest);
    Animal animalCheck = repository.findById(id).orElseThrow(() -> {
      throw new ResourceNotFoundException(id);
    });
    Animal animal = updateAnimalRequest.toAnimal();
    animal.setId(animalCheck.getId());
    animal = repository.save(animal);
    return AnimalResponse.from(animal);
  }
}
