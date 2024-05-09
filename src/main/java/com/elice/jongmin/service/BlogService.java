package com.elice.jongmin.service;

import com.elice.jongmin.domain.Article;
import com.elice.jongmin.dto.ArticleRequest;
import com.elice.jongmin.dto.UpdateArticleRequest;
import com.elice.jongmin.repository.BlogRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogService {

  private final BlogRepository blogRepository;



  // Create
  public Article save(ArticleRequest request) {
    return blogRepository.save(request.toEntity());
  }

  // Read
  public List<Article> findAll(){
    return blogRepository.findAll();
  }


  public Article findById(Long id){
    return blogRepository.findById(id).orElse(null);
  }

  // Update
  @Transactional
  public Article update(Long id, UpdateArticleRequest request){
    Article article = blogRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("not found : " + id));
    article.update(request.getTitle(), request.getContent());

    return article;

  }

  // Delete
  public void delete(Long id){
    blogRepository.deleteById(id);
  }

}
