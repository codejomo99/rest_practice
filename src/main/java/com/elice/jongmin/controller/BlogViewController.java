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
import org.springframework.web.bind.annotation.RequestParam;

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

  //내용 추가
  @GetMapping("/new-article")
  public String newArticle(@RequestParam(required = false, name="id" ) Long id, Model model) {

    if (id == null) {
      model.addAttribute("article", new ArticleViewResponse());
    } else {
      Article article = blogService.findById(id);
      model.addAttribute("article", new ArticleViewResponse(article));
    }

    return "newArticle";
  }


}
