package com.example.td.controller;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.td.enties.AppUser;
import com.example.td.service.AccountService;


public class AdminControlleur {
	@Autowired
	private AccountService accountService;
	//ajout appUser,
	@PostMapping("appuser/{id}")
	public AppUser addAppUser(@Valid @RequestBody AppUser appUser)
	{
		return accountService.saveUser(appUser);
	}
	//affichage appUser
	@GetMapping("appusers")
	public  List<AppUser> getAppUsersList()
	{
		return accountService.findAllAppUser();
	}
	//suppression
	@DeleteMapping("appuser/{id}")
	public AppUser deleteAppUser(@Valid @RequestBody AppUser appUser)
	{
		return accountService.deleteUser(appUser);
	}
}
