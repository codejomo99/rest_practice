package com.elice.jongmin.controller;

import com.elice.jongmin.domain.Article;
import com.elice.jongmin.dto.ArticleRequest;
import com.elice.jongmin.dto.ArticleResponse;
import com.elice.jongmin.service.BlogService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BlogApiController {

  private final BlogService blogService;

  @PostMapping("/api/articles")
  public ResponseEntity<Article> addArticle(@RequestBody ArticleRequest request){
    Article savedArticle = blogService.save(request);

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(savedArticle);
  }

  @GetMapping("/api/article")
  public ResponseEntity<List<ArticleResponse>> findAllArticle(@RequestParam Long id){
    List<ArticleResponse> articles = blogService.findAll()
        .stream()
        .map(ArticleResponse::new)
        .toList();

    return ResponseEntity.ok()
        .body(articles);
  }



}
