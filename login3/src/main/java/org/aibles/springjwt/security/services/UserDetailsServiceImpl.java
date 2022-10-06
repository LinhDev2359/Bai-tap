package org.aibles.springjwt.security.services;

import org.aibles.springjwt.entity.User;
import org.aibles.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  UserRepository userRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(email)
        .orElseThrow(
            () -> new UsernameNotFoundException("Email Not Found with email: " + email));

    return UserDetailsImpl.build(user);
  }

}
