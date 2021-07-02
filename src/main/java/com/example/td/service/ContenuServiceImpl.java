package com.example.td.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.td.enties.Contenu;
import com.example.td.repository.ContenuRepository;

@Service
@Transactional
public class ContenuServiceImpl implements ContenuService{

	@Autowired
	private ContenuRepository contenuRepository;
	
	@Override
	public List<Contenu> getAllContenus() {
		// TODO Auto-generated method stub
		return contenuRepository.findAll();
	}

//	@Override
//	public Contenu getContenuById(Contenu IdContenu) {
//		// TODO Auto-generated method stub
//		return contenuRepository.getById(IdContenu);
//	}

	@Override
	public Contenu deleteContenu(Contenu contenu) {
		contenuRepository.delete(contenu);
		return  contenu;
	}

	@Override
	public Contenu saveContenu(Contenu contenu) {
		return contenuRepository.save(contenu);
	}
    
}
