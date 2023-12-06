package com.springtest.photoz.service;

import org.springframework.stereotype.Service;

import com.springtest.photoz.model.Photo;
import com.springtest.photoz.repository.PhotozRepository;

//@Component
@Service
public class PhotoService {

    private final PhotozRepository photozRepository;

    public PhotoService(PhotozRepository photozRepository){
        this.photozRepository = photozRepository;
    }
    
    public Iterable<Photo> getAll() {
        return photozRepository.findAll();
    }

    
    public Photo get(Integer id) {
        return photozRepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
        photozRepository.deleteById(id);
    }

    public Photo save(String fileName, String contentType, byte[] data){
        Photo photo = new Photo();
        photo.setFileName(fileName);
        photo.setContentType(contentType);
        photo.setData(data);
        photozRepository.save(photo);
        return photo;
    }
    


    
}
