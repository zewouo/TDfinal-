package com.example.td.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.td.enties.AppRole;
import com.example.td.enties.AppUser;
import com.example.td.repository.AppRoleRepository;
import com.example.td.repository.AppUserRepository;



@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private AppUserRepository userRepository;
	@Autowired
	private AppRoleRepository roleRepository;

	@Override
	public AppUser saveUser(AppUser user) {
		String hashPW = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(hashPW);
		return userRepository.save(user);
	}

	@Override
	public AppRole saveRole(AppRole role) {
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		AppRole role = roleRepository.findByRoleName(roleName);
		AppUser user = userRepository.findByUsername(username);
		user.getRoles().add(role);

	}

	@Override
	public AppUser findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public List<AppUser> findAllAppUser() {
		return userRepository.findAll();
	}

	@Override
	public AppUser deleteUser(AppUser user) {
		userRepository.delete(user);
		return user;
	}

}
