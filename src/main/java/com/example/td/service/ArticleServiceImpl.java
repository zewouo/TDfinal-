package com.example.td.service;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.td.enties.Article;
import com.example.td.repository.ArticleRepository;


@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

	
	@Autowired
	private ArticleRepository articleRepository;

	@Override
	public List<Article> getAllAricles() {
		return articleRepository.findAll();
	}

	@Override
	public Article saveArticle(Article article) {
		
		return articleRepository.save(article);
	}
//	public Optional<Article> getArticleById(Long IdArticle) {
//		// TODO Auto-generated method stub
//		return articleRepository.findById(IdArticle);
//	}

	@Override
	public Article deleteArticle(Article IdArticle) {
	    articleRepository.delete(IdArticle);
		return IdArticle;
	}

}
