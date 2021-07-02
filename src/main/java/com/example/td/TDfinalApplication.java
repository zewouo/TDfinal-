package com.example.td;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.td.enties.AppRole;
import com.example.td.enties.AppUser;
import com.example.td.service.AccountService;



@SpringBootApplication
public class TDfinalApplication implements CommandLineRunner{
	@Autowired
	private AccountService accountService;
	
	public static void main(String[] args) {
		SpringApplication.run(TDfinalApplication.class, args);
	}
	@Bean
	public BCryptPasswordEncoder getBCPE() {
	return new BCryptPasswordEncoder();
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		accountService.saveUser( new AppUser("admin","1234",null));
		accountService.saveUser( new AppUser("user","1234",null));
		accountService.saveRole( new AppRole("ADMIN"));
		accountService.saveRole( new AppRole("EDITEUR"));
		accountService.addRoleToUser("admin", "ADMIN");
		accountService.addRoleToUser("user", "EDITEUR");
		
	}

}
