package org.aibles.okr.service;

import org.aibles.okr.dto.request.commit.CreateCommit;
import org.aibles.okr.dto.response.CommitResponse;


public interface CommitService {

  CommitResponse created(CreateCommit createCommit);

}
