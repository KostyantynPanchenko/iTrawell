package net.ukr.itrawell.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import net.ukr.itrawell.service.PostService;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("posts", postService.findAll());
        model.addAttribute("today", Calendar.getInstance());
        return "home";
    }
    
    @GetMapping("/{id}")
    public String getPost(@PathVariable("id") Integer id, Model model) {        
        model.addAttribute("post", postService.findOne(id));
        return "post";
    }
}
