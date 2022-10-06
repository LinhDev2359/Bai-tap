package org.aibles.okr.controller;

import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.aibles.okr.component.SearchList;
import org.aibles.okr.dto.request.objective.CreateObjective;
import org.aibles.okr.dto.request.objective.UpdateObjective;
import org.aibles.okr.dto.response.ObjectiveResponse;
import org.aibles.okr.service.ObjectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/objectives")
@Slf4j
public class ObjectiveController {

  private final ObjectiveService service;

  @Autowired
  public ObjectiveController(ObjectiveService service) {
    this.service = service;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ObjectiveResponse created(@RequestBody @Valid CreateObjective createObjective) {
    return service.created(createObjective);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public String deleteById(@PathVariable("id") long id) {

    service.delete(id);
    return "Successful delete";
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<ObjectiveResponse> list() {
    return service.list();
  }

  @PostMapping("/search")
  @ResponseStatus(HttpStatus.OK)
  public List<ObjectiveResponse> listSearch(@RequestBody SearchList searchList) {
    return service.listSearch(searchList);
  }

  @PutMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public ObjectiveResponse update(@PathVariable("id") long id,
      @RequestBody @Valid UpdateObjective updateObjective) {
    return service.update(id, updateObjective);
  }
}
