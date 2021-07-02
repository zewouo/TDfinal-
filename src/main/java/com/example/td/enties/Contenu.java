package com.example.td.enties;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.Data;

@Entity
@Data
public class Contenu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(max=250)
	@Column(nullable=false)
	private String titre;
	@NotNull
	@Size(max=250)
	@Column(nullable=false)
	private String dateHeure;
	@NotNull
	@Size(max=250)
	@Column(nullable=false)
	private String texte;
	@NotNull
	@Size(max=250)
	@Column(nullable=false)
	private String auteur;
	@NotNull
	@Column(nullable=false)
	private String url;
	
	private int idFile;
	
	@OneToOne(fetch =FetchType.LAZY,
			cascade = CascadeType.ALL,
			mappedBy = "contenu")
	private Article article;
	

}
