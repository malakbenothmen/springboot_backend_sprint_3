package com.malak.voyages.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity; 
import org.springframework.web.multipart.MultipartFile; 
import com.malak.voyages.entities.Image; 
 
public interface ImageService { 
     Image uplaodImage(MultipartFile file) throws IOException; 
     Image getImageDetails(Long id) throws IOException; 
     ResponseEntity<byte[]> getImage(Long id) throws IOException; 
     void deleteImage(Long id) ; 
     
     Image uplaodImageVoy(MultipartFile file,Long idVoy) throws IOException; 
     List<Image> getImagesParVoy(Long voyId);
} 