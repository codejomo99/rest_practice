package com.elice.jongmin.dto;

import com.elice.jongmin.domain.Article;
import lombok.Getter;

@Getter
public class ArticleListViewResponse {
  private final Long id;
  private final String title;
  private final String content;

  public ArticleListViewResponse(Article article){
    id = article.getId();
    title = article.getTitle();
    content = article.getContent();
  }
}
