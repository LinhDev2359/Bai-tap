package org.aibles.okr.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.aibles.okr.dto.request.commit.CreateCommit;
import org.aibles.okr.dto.response.CommitResponse;
import org.aibles.okr.entity.Commit;
import org.aibles.okr.repository.CommitRepository;
import org.aibles.okr.service.CommitService;

@Slf4j
public class CommitServiceImpl implements CommitService {

  private final CommitRepository repository;


  public CommitServiceImpl(CommitRepository repository) {
    this.repository = repository;
  }

  @Override
  public CommitResponse created(CreateCommit createCommit) {
    log.info("(Create)create commit: {}", createCommit);
    Commit commit = createCommit.toCommit();
    Commit create = repository.save(commit);
    CommitResponse commitCreated = CommitResponse.from(create);
    return commitCreated;
  }
}
