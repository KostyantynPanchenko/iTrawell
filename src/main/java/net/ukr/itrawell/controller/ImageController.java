package net.ukr.itrawell.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import net.ukr.itrawell.service.ImageService;

@Controller
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService imageService;
    
    @GetMapping("/{imageId}")
    public void getImage(@PathVariable("imageId") Integer imageId, HttpServletResponse response) {
        try{
            byte[] content = imageService.findOne(imageId).getData();
            System.out.println("image extracted from DB");
            if (content != null) {
                if (response != null) {
                    response.setContentType("image/jpg");
                    OutputStream out = response.getOutputStream();
                    out.write(content);
                    out.flush();
                    out.close();
                    System.out.printf("image %d retrieved%n", imageId);
                } else {
                    System.out.println("response == null");
                } 
            } else {
                System.out.println("data[] == null");
            }
        } catch (IOException e) {
            // LOG IT!
        }
        
    }
}
