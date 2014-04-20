package com.nhncorp.edu.plus.fileupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.nhncorp.edu.plus.fileupload.model.AttachFileList;
import com.nhncorp.lucy.spring.file.FileUploadItem;
import com.nhncorp.lucy.spring.file.manager.FileUploadManager;

@Controller
public class FileUploadController {
	@Autowired
	private FileUploadManager fileUploadManager;
	
	@RequestMapping(value="/plus/upload", method=RequestMethod.GET)
	public ModelAndView upload() throws Exception {
		ModelAndView mav = new ModelAndView("/plus/upload");
		return mav;
	}
	
	@RequestMapping(value="/plus/upload", method=RequestMethod.POST)
	public String upload(@RequestParam(value = "attachFile", required = false) MultipartFile file) throws Exception {
		if(file != null) {
			FileUploadItem fileItem = new FileUploadItem(file.getName(), file);
			fileUploadManager.upload(new FileUploadItem[] { fileItem });
		}

		return "redirect:./uploadComplete";
	}
	
	@RequestMapping(value="/plus/multi", method=RequestMethod.GET)
	public ModelAndView multi() throws Exception {
		ModelAndView mav = new ModelAndView("/plus/multi");
		return mav;
	}
	
	@RequestMapping(value="/plus/multi", method=RequestMethod.POST)
	public String multi(AttachFileList fileList) throws Exception {
		if(!fileList.getFileList().isEmpty()) {
			for (MultipartFile file : fileList.getFileList()) {
				if(file != null) {
					FileUploadItem fileItem = new FileUploadItem(file.getName(), file);
					fileUploadManager.upload(new FileUploadItem[] { fileItem });
				}
			}
		}
		
		return "redirect:./uploadComplete";
	}
	
	@RequestMapping("/plus/uploadComplete")
	public void uploadComplete() throws Exception {
	}
}
