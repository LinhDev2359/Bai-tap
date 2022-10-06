package org.aibles.login2.repository;

import java.util.Optional;
import org.aibles.login2.entity.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<ApiUser, Long> {

  Optional<ApiUser> findByUsername(String username);
}
