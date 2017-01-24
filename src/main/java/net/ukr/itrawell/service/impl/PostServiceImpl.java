package net.ukr.itrawell.service.impl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.ukr.itrawell.model.Image;
import net.ukr.itrawell.model.Post;
import net.ukr.itrawell.repository.ImageRepository;
import net.ukr.itrawell.repository.PostRepository;
import net.ukr.itrawell.service.PostService;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepo;

    @Autowired
    private ImageRepository imageRepo;

    public Post findOne(Integer id) {
        Optional<Post> post = postRepo.findOne(id);
        if (!post.isPresent()) {
            throw new EntityNotFoundException();
        }
        return post.get();
    }

    @Override
    public List<Post> findAll() {
        List<Post> posts = new ArrayList<>();
        posts.addAll(postRepo.findAll());
        return posts;
    }
    
    @Transactional(value = TxType.REQUIRED)
    @Override
    public void save(String title, String content, String country,
            String region, String city, String label, MultipartFile image) {

        Post post = new Post();
        populatePost(post, title, content, country, region, city);
        addImage(post, image);
        post.setCreated(LocalDateTime.now());

        postRepo.save(post);
        System.out.println("Post saved!");
    }

    private Post populatePost(Post post, String title, String content,
            String country, String region, String city) {
        post.setTitle(valueOf(title));
        post.setContent(valueOf(content));
        post.setCountry(valueOf(country));
        post.setRegion(valueOf(region));
        post.setCity(valueOf(city));        
        return post;
    }

    private void addImage(Post post, MultipartFile image) {
        try {
            Image img = (image.isEmpty() ? null : new Image(image.getBytes()));
            if (img != null) {
                img = imageRepo.save(img);
            }
            post.setImage(img);
        } catch (IOException e) {
            // TODO
            e.printStackTrace();
        }
    }

    private String valueOf(String value) {
        return value.trim().isEmpty() ? null : value.trim();
    }

    @Override
    public void update(Integer id, String title, String content, String country,
            String region, String city, String label, MultipartFile image, String[] deleteImage) {
        
        Optional<Post> option = postRepo.findOne(id);
        if (option.isPresent()) {
            Post post = option.get();
            populatePost(post, title, content, country, region, city);

            if (deleteImage != null) { // checkBox "delete image" is on
                System.out.print("DELETE IMAGE = TRUE -> ");
                System.out.println(deleteImage[0]);
                Image img = post.getImage();
                post.setImage(null);
                imageRepo.delete(img);
            } else if (!image.isEmpty()) {
                addImage(post, image);
            }
            postRepo.save(post);
        }
    }

    @Override
    public void delete(Integer id) {
        Optional<Post> option = postRepo.findOne(id);
        if (option.isPresent()) {
            postRepo.delete(option.get());
        } else {
            throw new EntityNotFoundException();
        }
    }
}
