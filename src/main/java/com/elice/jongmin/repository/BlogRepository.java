package com.elice.jongmin.repository;

import com.elice.jongmin.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {

}
