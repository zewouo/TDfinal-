package com.example.td.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.td.enties.Article;
import com.example.td.enties.Contenu;
import com.example.td.repository.ArticleRepository;
import com.example.td.repository.ContenuRepository;
import com.example.td.service.ArticleService;
import com.example.td.service.ContenuService;


@RestController
public class BusinessControlleur {
	@Autowired
	private ContenuService contenuService;
	@Autowired
	private ArticleService articleService;
	
	
	   //recuperer tous les articles
		@GetMapping("articles")
		public  List<Article> getArtclesList()
		{
			return articleService.getAllAricles();
		}
		//recuperer tous les contenus
		@GetMapping("contenus")
		public  List<Contenu> getContenuList()
		{
			return contenuService.getAllContenus();
		}
		//ajouter un contenu 
		@PostMapping("contenu/{id}")
		public Contenu addContenu(@Valid @RequestBody Contenu contenu)
		{
			return contenuService.saveContenu(contenu);
		}
		
		//ajouter un article
		@PostMapping("article/{id}")
		public Article addArticle(@Valid @RequestBody Article article)
		{
			return articleService.saveArticle(article);
		}
		//associer un article a un contenu
		
//		@PostMapping("")
//		public void addArticleAndContenu(@Valid @RequestBody Article article,@Valid @RequestBody Contenu contenu)
//		{
//			//toDo
//		}
		
		//chercher un article par Id
//		@GetMapping("")
//		public Article findArticleById() {
//			  return null;
//		}
		//chercher un contenu par Id
//		@GetMapping("")
//		public Contenu findContenuById() {
//			  return null;
//		}
		//supprimer un contenu
		@DeleteMapping("contenu/{id}")
		public Contenu deleteContenu(Contenu contenu) {
			  return contenuService.deleteContenu(contenu);
		}
		//supprimer un article
		@DeleteMapping("article/{id}")
		public Article deleteArticle(Article article) {
			  return articleService.deleteArticle(article);
		}
}
