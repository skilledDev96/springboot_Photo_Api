package com.springtest.photoz.clone;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotEmpty;

public class Photo {
    private String id;
    
    @NotEmpty
    private String fileName;

    @JsonIgnore
    private byte[] data;

    private String contentType;

    public Photo(){
    } 

    public Photo(String id, String fileName,String contentType){
        this.id = id;
        this.fileName = fileName;
        this.contentType = contentType;
    }
    
    //raw Data
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentType() {
        return contentType;
    }

}
