package com.wilsonfuro.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.wilsonfuro.workshopmongo.domain.Post;

@Repository
public interface PostRepository  extends MongoRepository<Post, String> {
	
	  @Query("{ 'Title' : { $regex: ?0, $options: 'i' } } ")
	 List<Post> serchTitle(String text);

	
	 List<Post> findByTitleContainingIgnoreCase(String text);
}
