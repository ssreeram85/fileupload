package com.tetrasoft.us.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class FileFormatType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Lob
	private byte[] uploadGovtIdData;
	private String uploadGovtIdName;
	private String uploadGovtIType;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "file_upload_model_id",nullable = false)
	private FileUploadModel uploadFiles;
	
	
	
	public FileUploadModel getUploadFiles() {
		return uploadFiles;
	}


	public void setUploadFiles(FileUploadModel uploadFiles) {
		this.uploadFiles = uploadFiles;
	}


	public FileFormatType(byte[] uploadGovtIdData, String uploadGovtIdName, String uploadGovtIType) {

		this.uploadGovtIdData = uploadGovtIdData;
		this.uploadGovtIdName = uploadGovtIdName;
		this.uploadGovtIType = uploadGovtIType;
	}
	
	
	public FileFormatType() {

	}


	public byte[] getUploadGovtIdData() {
		return uploadGovtIdData;
	}
	public void setUploadGovtIdData(byte[] uploadGovtIdData) {
		this.uploadGovtIdData = uploadGovtIdData;
	}
	public String getUploadGovtIdName() {
		return uploadGovtIdName;
	}
	public void setUploadGovtIdName(String uploadGovtIdName) {
		this.uploadGovtIdName = uploadGovtIdName;
	}
	public String getUploadGovtIType() {
		return uploadGovtIType;
	}
	public void setUploadGovtIType(String uploadGovtIType) {
		this.uploadGovtIType = uploadGovtIType;
	} 
	
	
	
}
