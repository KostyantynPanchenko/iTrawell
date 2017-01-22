package net.ukr.itrawell.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.ukr.itrawell.service.PostService;

@Controller
public class HomeController {
    
    @Autowired
    private PostService postService;
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("posts", postService.findAll());
        model.addAttribute("today", Calendar.getInstance());
        return "home";
    }
    

}
