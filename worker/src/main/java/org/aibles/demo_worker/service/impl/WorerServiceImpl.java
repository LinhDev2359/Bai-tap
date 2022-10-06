package org.aibles.demo_worker.service.impl;

import org.aibles.demo_worker.entity.Worker;
import org.aibles.demo_worker.mapper.WorkerMapper;
import org.aibles.demo_worker.repository.WorkerRepository;
import org.aibles.demo_worker.service.WorkerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorerServiceImpl implements WorkerService {
    private final WorkerRepository workerRepository;

    private final WorkerMapper workerMapper;
    public WorerServiceImpl(WorkerRepository workerRepository, WorkerMapper workerMapper) {
        this.workerRepository = workerRepository;
        this.workerMapper = workerMapper;
    }

    @Override
    public Worker createdWorker(Worker worker) {
        return null;
    }

    @Override
    public Worker updateWorker(long id, Worker workerUpdate) {
        Worker result = workerRepository.findById((int) id)
                .map(worker -> {
                    worker.setName(workerUpdate.getName());
                    worker.setAddress(workerUpdate.getAddress());
                    return worker;
                })
                .map(workerRepository::save)
                .orElse(null);
        return result;
    }

    @Override
    public void delete(long id) {
        workerRepository.findById((int) id)
                .map(worker -> {
                    workerRepository.delete(worker);
                    return worker;
                })
                .orElse(null);
    }

    @Override
    public List<Worker> listWorker() {
        return null;
    }
}
