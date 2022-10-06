package org.aibles.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.aibles.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
