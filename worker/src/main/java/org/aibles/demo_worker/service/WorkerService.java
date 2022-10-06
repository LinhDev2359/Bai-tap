package org.aibles.demo_worker.service;

import org.aibles.demo_worker.entity.Worker;

import java.util.List;

public interface WorkerService {
    Worker createdWorker (Worker worker);
    Worker updateWorker (long id, Worker worker);
    void delete(long id);
    List<Worker> listWorker();
}
