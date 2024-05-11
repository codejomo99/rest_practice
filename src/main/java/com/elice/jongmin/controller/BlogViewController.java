package com.elice.jongmin.controller;

import com.elice.jongmin.domain.Article;
import com.elice.jongmin.dto.ArticleListViewResponse;
import com.elice.jongmin.dto.ArticleViewResponse;
import com.elice.jongmin.service.BlogService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class BlogViewController {
  private final BlogService blogService;

  @GetMapping("/articles")
  public String getArticle(Model model){
    List<ArticleListViewResponse> articles = blogService
        .findAll()
        .stream()
        .map(ArticleListViewResponse::new)
        .toList();
    model.addAttribute("articles", articles);
    return "articleList.html";
  }

  @GetMapping("/articles/{id}")
  public String getArticle(@PathVariable("id") long id, Model model){
    Article article = blogService.findById(id);
    model.addAttribute("article", new ArticleViewResponse(article));
    return "article";
  }

}
