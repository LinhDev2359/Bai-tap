package org.aibles.animal.repository;

import java.util.List;
import org.aibles.animal.dto.request.ListAnimalRequest;
import org.aibles.animal.dto.response.AnimalResponse;
import org.aibles.animal.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

  //List<AnimalResponse> findAll(ListAnimalRequest listAnimalRequest);
}
