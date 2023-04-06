package org.aibles.zipkinclient;

import brave.Tracer;
import brave.Span;
import brave.Tracing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import zipkin2.reporter.AsyncReporter;
import zipkin2.reporter.Sender;
//import zipkin2.Span;
//import zipkin2.Tracer;

import zipkin2.reporter.okhttp3.OkHttpSender;


@RestController

public class ZipkinClient1Controller {

  @Autowired
  private RestTemplate restTemplate;

  public ZipkinClient1Controller(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }


  @GetMapping("/hello")
  public String hello() {


    Sender sender = OkHttpSender.create("http://localhost:9411/api/v2/spans");

    Tracing tracing = Tracing.newBuilder()
        .localServiceName("my-service1")
        .spanReporter(AsyncReporter.create(sender))
        .build();

    Tracer tracer = tracing.tracer();

    Span newSpan = tracer.nextSpan().name("world span2").start();
    try (Tracer.SpanInScope ws = tracer.withSpanInScope(newSpan)) {
      String response = restTemplate.getForObject("http://localhost:8081/greet", String.class);
      return "Greeting, " + response;
    } finally {
      newSpan.finish();
    }


  }


}
