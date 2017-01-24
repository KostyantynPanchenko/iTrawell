package net.ukr.itrawell.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import net.ukr.itrawell.model.Post;

public interface PostService {
    
    Post findOne(Integer id);
    
    List<Post> findAll();

    void save(String title, String content, String country, String region,
            String city, String label, MultipartFile image);

    void update(Integer id, String title, String content, String country, String region,
            String city, String label, MultipartFile image, String[] deleteImage);

    void delete(Integer id);

}
