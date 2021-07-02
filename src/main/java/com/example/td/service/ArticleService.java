package com.example.td.service;

import java.util.List;
	
import com.example.td.enties.Article;

public interface ArticleService {

	List<Article> getAllAricles();

	// Optional<Article> getArticleById(Long IdArticle);

	Article deleteArticle(Article IdArticle);

	Article saveArticle(Article article);

}
