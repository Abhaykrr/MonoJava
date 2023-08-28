package com.monocept.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.entity.ImageData;
import com.monocept.repository.ImageRepository;


import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageService {
	
	@Autowired
	private ImageRepository imageRepo;
	
	
	 public String uploadImage(MultipartFile file) throws IOException {

	        ImageData imageData = imageRepo.save(ImageData.builder()
	                .name(file.getOriginalFilename())
	                .type(file.getContentType())
	                .imageData(file.getBytes()).build());
	        if (imageData != null) {
	            return "file uploaded successfully : " + file.getOriginalFilename();
	        }
	        return null;
	    }

	    public byte[] downloadImage(String fileName){
	        Optional<ImageData> dbImageData = imageRepo.findByName(fileName);
	        byte[] images=dbImageData.get().getImageData();
	        return images;
	    }
	

}
