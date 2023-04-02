package org.aibles.zipkinclient;


import brave.Span;
import brave.Tracer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController

public class ZipkinClient1Controller {

  private final Logger logger = LoggerFactory.getLogger(ZipkinClient1Controller.class);

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private Tracer tracer;

  public ZipkinClient1Controller(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @GetMapping("/hello")
  public String hello() {
    Span newSpan = tracer.nextSpan().name("world span").start();
    try (Tracer.SpanInScope ws = tracer.withSpanInScope(newSpan)) {
      String response = restTemplate.getForObject("http://localhost:8082/greet", String.class);
      return "Hello, " + response;
    } finally {
      newSpan.finish();
    }
  }

  @GetMapping("/greet")
  public String greet() {
    logger.info("greet() method is called");
    return "World";
  }

}
