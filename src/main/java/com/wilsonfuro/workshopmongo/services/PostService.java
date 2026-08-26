package com.wilsonfuro.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilsonfuro.workshopmongo.domain.Post;
import com.wilsonfuro.workshopmongo.repository.PostRepository;
import com.wilsonfuro.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	
	@Autowired
	private PostRepository repo;
	
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById  ( id);
		Post post = obj.orElse(null);
		if (post == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return post;
		
	}
	
	public List <Post> findByTitle(String text) {
		
		return repo.serchTitle(text);
		
	}
	     

}
