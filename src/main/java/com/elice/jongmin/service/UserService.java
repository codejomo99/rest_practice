package com.elice.jongmin.service;

import com.elice.jongmin.domain.User;
import com.elice.jongmin.dto.AddUserRequest;
import com.elice.jongmin.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
  private final UserRepository userRepository;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  public Long save(AddUserRequest dto){
    return userRepository.save(User.builder()
        .email(dto.getEmail())
        .password(bCryptPasswordEncoder.encode(dto.getPassword()))
        .build()).getId();
  }
}
