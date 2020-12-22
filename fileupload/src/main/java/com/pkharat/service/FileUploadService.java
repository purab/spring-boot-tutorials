package com.pkharat.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	
	public void uploadFile(MultipartFile file ) throws IllegalStateException, IOException {
		file.transferTo(new File("D:\\eclipse-workspace\\fileupload\\uploads\\"+file.getOriginalFilename()));
	}

}
