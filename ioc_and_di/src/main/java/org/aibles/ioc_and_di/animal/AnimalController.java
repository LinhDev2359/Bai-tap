package org.aibles.ioc_and_di.animal;

import org.aibles.ioc_and_di.animal.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AnimalController {

  @Autowired
  Animal animal;



}
