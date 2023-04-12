package org.aibles.zipkinclient;

import brave.Span;
import brave.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController

public class ZipkinClient1Controller {

  private final Tracer tracer;
  @Autowired
  private RestTemplate restTemplate;

  public ZipkinClient1Controller(RestTemplate restTemplate, Tracer tracer) {
    this.restTemplate = restTemplate;
    this.tracer = tracer;
  }


  @GetMapping("/hello")
  public String hello() {
    Span newSpan = tracer.nextSpan().name("world span2").start();
    try (Tracer.SpanInScope ws = tracer.withSpanInScope(newSpan.start())) {
      String response = restTemplate.getForObject("http://localhost:8081/greet", String.class);

      return "Greeting, " + response;
    } finally {
      newSpan.finish();
    }


  }


}
