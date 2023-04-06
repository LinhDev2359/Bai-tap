package org.aibles.zipkinclient;

import brave.Tracing;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ZipkinClientConfiguration {

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

}
