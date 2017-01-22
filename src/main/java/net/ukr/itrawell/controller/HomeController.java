package net.ukr.itrawell.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class HomeController {
    
    public String home(Model model) {
        model.addAttribute("today", Calendar.getInstance());
        return "home";
    }
    

}
