package org.aibles.demo_worker.controller;

import org.aibles.demo_worker.entity.Worker;
import org.aibles.demo_worker.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/workers")
public class WorkerController {
    private  final WorkerService workerService;

    @Autowired
    public WorkerController(WorkerService workerService) {
        this.workerService =workerService;
    }

    @PostMapping
    public ResponseEntity<Worker> createdWorker(@RequestBody Worker worker) {
        Worker worker1 = workerService.createdWorker(worker);
        return new ResponseEntity<>(worker1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Worker>> workerList() {
        List<Worker> workerList = workerService.listWorker();
        return new ResponseEntity<>(workerList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Worker> updateWorker(@PathVariable("id") int workerId,
                                               @RequestBody Worker worker) {
        final Worker updatedWorker = workerService.updateWorker(workerId, worker);
        return new ResponseEntity<>(updatedWorker, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorker(@PathVariable("id") int workerId) {
        workerService.delete(workerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
