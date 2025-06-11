package com.tastytown.backend.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tastytown.backend.service.IImageService;

@Service
public class ImageServiceImpl implements IImageService{
    @Value("${upload.file.dir}")
    private String FILE_DIR;

    @Override
    public ResponseEntity<byte[]> extractFoodImage(String foodImageName) throws IOException{
        if(foodImageName == null || foodImageName.isEmpty()) {
            throw new NoSuchElementException("Image name Not Found");
        }

        var file = new File(FILE_DIR + File.separator + foodImageName);
        if(!file.exists()) {
            throw new FileNotFoundException("File Not foudn with name " + foodImageName);
        }

        var fis = new FileInputStream(file);
        byte[] image = fis.readAllBytes();
        fis.close();

        var lowerFoodImageName = foodImageName.toLowerCase();
        String contentType = "";
        if(lowerFoodImageName.endsWith(".jpg") || lowerFoodImageName.endsWith(".jpeg")) {
            contentType = MediaType.IMAGE_JPEG_VALUE;
        } else if (lowerFoodImageName.endsWith(".png")) {
            contentType = MediaType.IMAGE_PNG_VALUE;
        }

        return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType(contentType))
                        .body(image);
    }
    
}
