package com.example.td.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.td.enties.AppRole;

public interface AppRoleRepository extends JpaRepository<AppRole, String> {
	public AppRole findByRoleName(String roleName);
}
