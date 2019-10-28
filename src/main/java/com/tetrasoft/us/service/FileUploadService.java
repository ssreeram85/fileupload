package com.tetrasoft.us.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tetrasoft.us.model.FileUploadModel;
import java.lang.String;
import java.util.List;

import javax.transaction.Transactional;

public interface FileUploadService  extends JpaRepository<FileUploadModel, Integer>{
	@Transactional
	FileUploadModel findByEmail(String email);

}
