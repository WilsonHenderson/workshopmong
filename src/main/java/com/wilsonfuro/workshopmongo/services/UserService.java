package com.wilsonfuro.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilsonfuro.workshopmongo.domain.User;
import com.wilsonfuro.workshopmongo.repository.UserRepository;
import com.wilsonfuro.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
		
	}
	
	public User findById(String id) {
		Optional<User> obj  = repo.findById(id);
		
		User user = obj.orElse(null);
		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user;
		
	}

}
