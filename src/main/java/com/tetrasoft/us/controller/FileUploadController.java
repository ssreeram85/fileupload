package com.tetrasoft.us.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tetrasoft.us.model.FileFormatType;
import com.tetrasoft.us.model.FileUploadModel;
import com.tetrasoft.us.service.FileUploadService;

@RestController
public class FileUploadController {
	
	@Autowired
	private FileUploadService service;
	
	@PostMapping("/upload" )
	public String upload(@RequestParam("files") MultipartFile[] files,@RequestParam("firstName") String firstName,@RequestParam("email") String email) throws Exception {
		List<FileFormatType> list = new ArrayList<FileFormatType>();
		FileUploadModel model =new FileUploadModel();
		model.setFirstName(firstName);
		model.setEmail(email);
		for(MultipartFile file:files) {
			FileFormatType type = new FileFormatType(file.getBytes(), file.getOriginalFilename(), file.getContentType());
			list.add(type);
			type.setUploadFiles(model);
		}
		model.setUploadedList(list);
		FileUploadModel save = service.save(model);
		List<FileUploadModel> findAll = service.findAll();
		System.out.println(findAll);
		return "done";

	}

	@GetMapping("/download/{email}")
	public ResponseEntity<Resource> getAllUploadFiles(@PathVariable String email, HttpServletResponse response,
			HttpServletRequest request) throws Exception {

		FileUploadModel findByEmail = service.findByEmail(email);
		List<FileFormatType> uploadedList = findByEmail.getUploadedList();
		for (FileFormatType type : uploadedList) {
			return ResponseEntity.ok().contentType(MediaType.parseMediaType(type.getUploadGovtIType()))
					.header(HttpHeaders.CONTENT_DISPOSITION,
							"attachment; filename=\"" + type.getUploadGovtIdName() + "\"")
					.body(new ByteArrayResource(type.getUploadGovtIdData()));
		}

		return null;

	}

	public List<FileFormatType> getAllFiles(MultipartFile[] files) throws Exception{
		List<FileFormatType> list = new ArrayList<FileFormatType>();
		
		for(MultipartFile file:files) {
			FileFormatType type = new FileFormatType(file.getBytes(), file.getOriginalFilename(), file.getContentType());
			list.add(type);
		}
		return list;
	}
	

}
