package com.nhncorp.edu.plus.fileupload.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class AttachFileList {
	private List<MultipartFile> fileList = null;
	
	public AttachFileList() {
		fileList = new ArrayList<MultipartFile>();
	}

	public List<MultipartFile> getFileList() {
		return fileList;
	}

	public void setFileList(List<MultipartFile> fileList) {
		this.fileList = fileList;
	}
}


