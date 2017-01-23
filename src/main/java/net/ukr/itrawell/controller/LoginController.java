package net.ukr.itrawell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {
        
        ModelAndView model = new ModelAndView("login");
        
        if (error != null) {
            model.addObject("errorMsg", "Invalid username and/or password!");
        }
        
        if (logout != null) {
            model.addObject("logoutMsg", "You've been successfully logged out!");
        }
        
        return model;
    }
}
