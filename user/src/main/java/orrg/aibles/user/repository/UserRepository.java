package orrg.aibles.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import orrg.aibles.user.entity.ModelValidator;
import orrg.aibles.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
