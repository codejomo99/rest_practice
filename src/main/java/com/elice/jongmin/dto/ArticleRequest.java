package com.elice.jongmin.dto;


import com.elice.jongmin.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ArticleRequest {

  private String title;

  private String content;

  public Article toEntity(){
    return Article.builder()
        .title(title)
        .content(content)
        .build();
  }

}
