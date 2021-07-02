package com.example.td.service;

import java.util.List;

import com.example.td.enties.Contenu;



public interface ContenuService {
	List<Contenu> getAllContenus();

	//public Contenu getContenuById(Contenu IdContenu);

	public Contenu deleteContenu(Contenu contenu);

	public Contenu saveContenu(Contenu contenu);
}
