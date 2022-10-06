package org.aibles.animal.service;

import java.util.List;
import org.aibles.animal.dto.request.CreateAnimalRequest;
import org.aibles.animal.dto.request.ListAnimalRequest;
import org.aibles.animal.dto.request.UpdateAnimalRequest;
import org.aibles.animal.dto.response.AnimalResponse;
import org.aibles.animal.entity.Animal;

public interface AnimalService {

  AnimalResponse created(CreateAnimalRequest request);

  List<Animal> list(ListAnimalRequest listAnimalRequest);

  AnimalResponse update_by_id(long id, UpdateAnimalRequest updateAnimalRequest);


}
