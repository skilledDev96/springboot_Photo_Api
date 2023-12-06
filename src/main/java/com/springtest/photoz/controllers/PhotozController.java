package com.springtest.photoz.controllers;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.springtest.photoz.model.Photo;
import com.springtest.photoz.service.PhotoService;

@RestController
public class PhotozController {

    private final PhotoService photoService;

    public PhotozController(PhotoService photoService){
        this.photoService = photoService;
    }

    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/photoz")
    public Iterable<Photo> get(){
        return photoService.getAll();
    }
    
    @GetMapping("/photoz/{id}")
    public Photo get(@PathVariable Integer id){
        Photo photo = photoService.get(id);
        if(photo == null) throw new ResponseStatusException((HttpStatus.NOT_FOUND));
        return photo;
    }

     @DeleteMapping("/photoz/{id}")
    public void delete(@PathVariable Integer id){
        photoService.remove(id);
    }

     @PostMapping("/photoz")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException{
       return photoService.save(file.getOriginalFilename(),file.getContentType(),file.getBytes() );
    }
}
