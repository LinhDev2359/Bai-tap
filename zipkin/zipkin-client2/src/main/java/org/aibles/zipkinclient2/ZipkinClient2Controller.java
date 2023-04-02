package org.aibles.zipkinclient2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZipkinClient2Controller {

  private final Logger logger = LoggerFactory.getLogger(ZipkinClient2Controller.class);

  @GetMapping("/greet")
  public String greet() {
    logger.info("greet() method is called");
    return "World";
  }
}
