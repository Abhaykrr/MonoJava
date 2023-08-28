package com.monocept.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.monocept.service.ImageService;

@RestController
public class ImageRestController {
	
	@Autowired
	private ImageService imageService;
	
	@PostMapping("/addimage")
	public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
		String uploadImage = imageService.uploadImage(file);
		return ResponseEntity.status(HttpStatus.OK)
				.body(uploadImage);
	}

	@GetMapping("/image/{fileName}")
	public ResponseEntity<?> downloadImage(@PathVariable String fileName){
		byte[] imageData=imageService.downloadImage(fileName);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(imageData);

	}
	
	@PostMapping("/addpdf")
	public ResponseEntity<?> uploadPDF(@RequestParam("pdf")MultipartFile file) throws IOException {
		String uploadImage = imageService.uploadImage(file);
		return ResponseEntity.status(HttpStatus.OK)
				.body(uploadImage);
	}
	
	@GetMapping("/pdf/{fileName}")
	public ResponseEntity<?> downloadPDF(@PathVariable String fileName){
		byte[] pdfData=imageService.downloadImage(fileName);
		
		
		    return new ResponseEntity<>(pdfData, HttpStatus.OK);

	}

}
