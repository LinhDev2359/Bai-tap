package org.aibles.okr.repository;

import org.aibles.okr.entity.KeyResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyResultsRepository extends JpaRepository<KeyResults, Long> {

}
