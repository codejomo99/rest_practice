package com.elice.jongmin.service;

import com.elice.jongmin.domain.Article;
import com.elice.jongmin.dto.ArticleRequest;
import com.elice.jongmin.repository.BlogRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogService {

  private final BlogRepository blogRepository;


  public Article save(ArticleRequest request) {
    return blogRepository.save(request.toEntity());
  }

  public List<Article> findAll(){
    return blogRepository.findAll();
  }


  public Article findById(Long id){
    return blogRepository.findById(id).orElse(null);
  }

}
