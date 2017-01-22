package net.ukr.itrawell.service;

import java.util.List;

import net.ukr.itrawell.model.Post;

public interface PostService {
    
    Post findOne(Integer id);
    
    List<Post> findAll();

}
