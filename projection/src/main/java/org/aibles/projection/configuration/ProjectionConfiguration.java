package org.aibles.projection.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "org.aibles.projection.repository")
@ComponentScan(basePackages = "org.aibles.projection.repository")
public class ProjectionConfiguration {

}
