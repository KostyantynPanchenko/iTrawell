package net.ukr.itrawell.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ukr.itrawell.model.Post;
import net.ukr.itrawell.repository.PostRepository;
import net.ukr.itrawell.service.PostService;

@Service
public class PostServiceImpl implements PostService {

    @Autowired 
    private PostRepository postRepository;
    
    public Post findOne(Integer id) {
        Optional<Post> post = postRepository.findOne(id);
        if (!post.isPresent()) {
            throw new EntityNotFoundException();
        }
        return post.get();
    }

    @Override
    public List<Post> findAll() {
        List<Post> posts = new ArrayList<>();
        posts.addAll(postRepository.findAll());
        return posts;
    }
}
