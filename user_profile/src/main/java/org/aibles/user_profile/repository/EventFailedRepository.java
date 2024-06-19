package org.aibles.user_profile.repository;

import org.aibles.user_profile.entity.EventFailed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventFailedRepository extends JpaRepository<EventFailed, String> {

}
