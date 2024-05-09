package com.elice.jongmin.controller;

import com.elice.jongmin.domain.Article;
import com.elice.jongmin.dto.ArticleRequest;
import com.elice.jongmin.dto.ArticleResponse;
import com.elice.jongmin.dto.UpdateArticleRequest;
import com.elice.jongmin.service.BlogService;
import jakarta.websocket.server.PathParam;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BlogApiController {

  private final BlogService blogService;

  // POST
  @PostMapping("/api/articles")
  public ResponseEntity<Article> addArticle(@RequestBody ArticleRequest request){
    Article savedArticle = blogService.save(request);

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(savedArticle);
  }

  // GET
  @GetMapping("/api/articles")
  public ResponseEntity<List<ArticleResponse>> findAllArticle(){
    List<ArticleResponse> articles = blogService.findAll()
        .stream()
        .map(ArticleResponse::new)
        .toList();

    return ResponseEntity.ok()
        .body(articles);
  }

  @GetMapping("/api/article/{id}")
  public ResponseEntity<ArticleResponse> findByIdArticle(@PathVariable("id") Long id){
    Article article = blogService.findById(id);

    return ResponseEntity.ok()
        .body(new ArticleResponse(article));
  }

  // UPDATE
  @PutMapping("/api/article/{id}")
  public ResponseEntity<Article> updateArticle( @PathVariable("id") Long id, @RequestBody UpdateArticleRequest request){
    Article article = blogService.update(id,request);

    return ResponseEntity.ok()
        .body(article);
  }


  // DELETE
  @DeleteMapping("/api/article/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
    blogService.delete(id);

    return ResponseEntity.ok(null);
  }

}
