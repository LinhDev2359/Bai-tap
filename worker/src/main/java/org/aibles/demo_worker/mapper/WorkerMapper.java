package org.aibles.demo_worker.mapper;

import org.aibles.demo_worker.dto.WorkerDto;
import org.aibles.demo_worker.entity.Worker;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class WorkerMapper {
    private ModelMapper modelMapper;

    public WorkerMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public WorkerDto mapToDto(Worker worker) {
        return modelMapper.map(worker, WorkerDto.class);
    }
    public Worker mapToEntity(Worker worker, WorkerDto workerDto) {
        modelMapper.map(workerDto,worker);
        return worker;
    }
}
