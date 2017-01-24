package net.ukr.itrawell.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import net.ukr.itrawell.service.PostService;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;   
    
    @GetMapping("/{id}")
    public String getPost(@PathVariable("id") Integer id, Model model) {        
        model.addAttribute("post", postService.findOne(id));
        return "post";
    }
    
    @GetMapping("/new")
    public String getPost() {
        return "new-post";
    }
    
    @PostMapping("/new")
    public String getPost(@RequestParam(name = "title", required = true) String title, 
            @RequestParam(name = "content", required = true) String content,
            @RequestParam(name = "country") String country,
            @RequestParam(name = "region") String region,
            @RequestParam(name = "city", required = true) String city,
            @RequestParam(name = "label") String label,
            @RequestParam(name = "image") MultipartFile image) {
        
        postService.save(title, content, country, region, city, label, image);
        return "redirect:/";
    }
    
    @GetMapping("/{id}/edit")
    public String editPost(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("post", postService.findOne(id));
        return "edit-post";
    }
    
    @PostMapping("/{id}/edit")
    public String editPost(@PathVariable("id") Integer id,
            @RequestParam(name = "deleteImage", required = false) String[] deleteImage,
            @RequestParam(name = "title", required = true) String title, 
            @RequestParam(name = "content", required = true) String content,
            @RequestParam(name = "country") String country,
            @RequestParam(name = "region") String region,
            @RequestParam(name = "city", required = true) String city,
            @RequestParam(name = "label") String label,
            @RequestParam(name = "image", required = false) MultipartFile image) {

        postService.update(id, title, content, country, region, city, label, image, deleteImage);
        return "redirect:/post/" + id;
    }
    
    @GetMapping("/{id}/delete")
    public String deletePost(@PathVariable("id") Integer id) {
        postService.delete(id);
        return "redirect:/";
    }
}
