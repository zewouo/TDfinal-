package com.example.td.service;

import java.util.List;

import com.example.td.enties.AppRole;
import com.example.td.enties.AppUser;

public interface AccountService {
	public AppUser saveUser(AppUser user);
	public AppRole saveRole(AppRole role);
	public void addRoleToUser(String username,String roleName);
	public AppUser findUserByUsername(String username); 
	public List<AppUser> findAllAppUser();
	public AppUser deleteUser(AppUser user);

}
