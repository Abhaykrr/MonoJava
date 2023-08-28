package com.monocept.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monocept.entity.ImageData;

public interface ImageRepository extends JpaRepository<ImageData, Integer>{

	  Optional<ImageData> findByName(String fileName);
}
