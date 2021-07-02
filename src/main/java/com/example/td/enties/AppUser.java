package com.example.td.enties;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
	@Id
	@NotNull
	@Size(max=255)
	@Column(nullable=false)
	private String username;
	@NotNull
	@Size(max=255)
	@Column(nullable=false)
	private String password;
	@ManyToMany(fetch= FetchType.EAGER)
	private Collection<AppRole> roles=new ArrayList<>();
}
