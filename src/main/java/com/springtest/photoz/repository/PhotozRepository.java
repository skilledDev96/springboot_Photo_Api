package com.springtest.photoz.repository;

import org.springframework.data.repository.CrudRepository;

import com.springtest.photoz.model.Photo;

public interface PhotozRepository extends CrudRepository<Photo,Integer>{
    

}