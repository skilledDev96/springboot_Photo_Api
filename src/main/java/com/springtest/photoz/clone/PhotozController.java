package com.springtest.photoz.clone;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;

@RestController
public class PhotozController {

    private Map<String, Photo> db = new HashMap<>(){{
        put("1", new Photo("1", "hello.jpg"));
    }};

    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/photoz")
    public Collection<Photo> get(){
        return db.values();
    }
    
    @GetMapping("/photoz/{id}")
    public Photo get(@PathVariable String id){
        Photo photo = db.get(id);
        if(photo == null) throw new ResponseStatusException((HttpStatus.NOT_FOUND));
        return photo;
    }

     @DeleteMapping("/photoz/{id}")
    public void delete(@PathVariable String id){
        Photo photo = db.remove(id);
        if(photo == null) throw new ResponseStatusException((HttpStatus.NOT_FOUND));
    }

     @PostMapping("/photoz")
    public Photo create(@RequestBody @Valid Photo photo){
        photo.setId(UUID.randomUUID().toString());
        db.put(photo.getId(), photo);
        return photo;
    }
}
