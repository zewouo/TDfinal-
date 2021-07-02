package com.example.td.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.td.enties.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
	Optional<Article> findById(Long IdArticle);
}
