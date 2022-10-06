package org.aibles.demo_worker.configuration;

import org.aibles.demo_worker.mapper.WorkerMapper;
import org.aibles.demo_worker.repository.WorkerRepository;
import org.aibles.demo_worker.service.WorkerService;
import org.aibles.demo_worker.service.impl.WorerServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"org.aibles.demo_worker.repository"})
@ComponentScan(basePackages = {"org.aibles.demo_worker.repository"})
public class WorkerConfiguration {
        @Bean
        public ModelMapper modelMapper() {
            return new ModelMapper();
        }
        @Bean
        public WorkerService workerService (WorkerRepository workerRepository, WorkerMapper workerMapper) {
            return new WorerServiceImpl(workerRepository,  workerMapper);
        }

}
