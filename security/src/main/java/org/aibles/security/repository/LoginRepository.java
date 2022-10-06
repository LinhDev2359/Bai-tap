package org.aibles.security.repository;

import java.util.Optional;
import org.aibles.security.entity.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Logger, Long> {

  Optional<Logger> findByUsername(String username);
  Boolean existsByUsername(String username);
  Boolean existsByUsernameAndPassword(String username, String password);
}
