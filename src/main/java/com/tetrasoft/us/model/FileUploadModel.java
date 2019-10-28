package com.tetrasoft.us.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
//@Table(name = "file_upload")
public class FileUploadModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "file_upload_id")
	private Integer id;
	private String firstName;
	private String email;
	
	@OneToMany(mappedBy = "uploadFiles",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	List<FileFormatType> uploadedList;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public List<FileFormatType> getUploadedList() {
		return uploadedList;
	}

	public void setUploadedList(List<FileFormatType> uploadedList) {
		this.uploadedList = uploadedList;
	}
	


}
