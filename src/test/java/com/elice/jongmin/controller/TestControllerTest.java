package com.elice.jongmin.controller;

import com.elice.jongmin.domain.Member;
import com.elice.jongmin.repository.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class TestControllerTest {

  @Autowired
  protected MockMvc mockMvc;

  @Autowired
  private WebApplicationContext context;

  @Autowired
  private MemberRepository memberRepository;

  @BeforeEach
  public void mockMvcSetUp(){
    this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
        .build();
  }

  @AfterEach
  public void cleanUp(){
    memberRepository.deleteAll();
  }

  @DisplayName("getAllMembers: 멤버 조회에 성공")
  @Test
  public void getAllMembers() throws Exception{
    // given
    final String url = "/test";
    Member savedMember1 = memberRepository.save(new Member(1L,"test1"));
    Member savedMember2 = memberRepository.save(new Member(2L,"test2"));
    Member savedMember3 = memberRepository.save(new Member(3L,"test3"));

    // when
    final ResultActions result = mockMvc.perform(get(url).accept(MediaType.APPLICATION_JSON));

    // then
    result
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].id").value(savedMember1.getId()))
        .andExpect(jsonPath("$[0].name").value(savedMember1.getName()));
  }

}
