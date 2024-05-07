package com.elice.jongmin.service;


import com.elice.jongmin.domain.Member;
import com.elice.jongmin.repository.MemberRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

  @Autowired
  MemberRepository memberRepository;

  public List<Member> getAllMembers(){
    return memberRepository.findAll();
  }
}
