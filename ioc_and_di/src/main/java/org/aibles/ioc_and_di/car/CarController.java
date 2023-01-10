package org.aibles.ioc_and_di.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CarController {

  @Autowired
  Car car;
}
