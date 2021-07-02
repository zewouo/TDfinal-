package com.example.td.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.td.enties.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, String> {
	public AppUser findByUsername(String username);
}
