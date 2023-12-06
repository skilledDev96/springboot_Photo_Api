package com.springtest.photoz.clone;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

//@Component
@Service
public class PhotoService {

    
    private Map<String, Photo> db = new HashMap<>(){{
        put("1", new Photo("1", "hello.jpg", "image/jpg"));
    }};

    
    public Collection<Photo> getAll() {
        return db.values();
    }

    
    public Photo get(String id) {
        return db.get(id);
    }

    public Photo remove(String id) {
        return db.remove(id);
    }

    public void put(String id, Photo photo) {
    }

    public Photo save(String fileName, String contentType, byte[] data){
        Photo photo = new Photo();
        photo.setContentType(contentType);
        photo.setId(UUID.randomUUID().toString());
        photo.setFileName(fileName);
        photo.setData(data);
        db.put(photo.getId(), photo);
        return photo;
    }
    


    
}
