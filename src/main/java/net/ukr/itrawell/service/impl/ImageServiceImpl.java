package net.ukr.itrawell.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ukr.itrawell.model.Image;
import net.ukr.itrawell.repository.ImageRepository;
import net.ukr.itrawell.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;
    
    @Override
    public Image findOne(Integer id) {        
        return imageRepository.findOne(id).get();
    }

}
