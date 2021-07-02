package com.example.td.enties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.Data;

@Entity
@Data
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	@Size(max=256)
	@Column(nullable=false)
	private String titre;
	@NotNull
	@Size(max=256)
	@Column(nullable=false)
	private String url;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="contenu_id",nullable = false)
	private Contenu contenu;
}
