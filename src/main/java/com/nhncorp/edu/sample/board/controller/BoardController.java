package com.nhncorp.edu.sample.board.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.nhncorp.edu.sample.board.bo.BoardBO;
import com.nhncorp.edu.sample.board.model.BoardInfo;
import com.nhncorp.lucy.spring.core.data.DataHandler;
import com.nhncorp.lucy.spring.core.data.DataHandlerFactory;
import com.nhncorp.lucy.spring.core.web.helper.PagerInfo;
import com.nhncorp.lucy.spring.file.FileUploadItem;
import com.nhncorp.lucy.spring.file.manager.FileUploadManager;
import com.nhncorp.lucy.spring.mvc.view.navigation.AlertAndPostView;

@Controller
@RequestMapping("/sample/board")
public class BoardController {
	@Autowired
	private BoardBO bo;
	
	@Autowired
	private FileUploadManager fileUploadManager;
	
	@RequestMapping("/list.nhn")
	public ModelAndView list(HttpServletRequest req, String id, @RequestParam(value="page", required=true, defaultValue="1") String page) throws Exception {
		ModelAndView mav = new ModelAndView("/board/list");
		mav.addObject("id", id);
		
		int totalSize = bo.getBoardCount();
		PagerInfo pagerInfo = new PagerInfo(req, "default", totalSize);
		pagerInfo.setPage(Integer.parseInt(page));
		pagerInfo.setQueryString("id=" + id);
		
		List<BoardInfo> boardList = null;
		
		if (totalSize > 0) {
			int from = pagerInfo.getStartRownum();
			int to = pagerInfo.getEndRownum();

			boardList = bo.getBoardList((from - 1), (to - from + 1));
		}
		
		mav.addObject("boardList", boardList);
		mav.addObject("page", pagerInfo.getPage());
		
		return mav;
	}
	
	@RequestMapping("/myList.nhn")
	public ModelAndView myList(HttpServletRequest req, String id, @RequestParam(value="page", required=true, defaultValue="1") String page) throws Exception {
		ModelAndView mav = new ModelAndView("/board/myList");
		mav.addObject("id", id);
		
		int totalSize = bo.getBoardCount(id);
		PagerInfo pagerInfo = new PagerInfo(req, "my", totalSize);
		pagerInfo.setPage(Integer.parseInt(page));
		pagerInfo.setQueryString("id=" + id);
		
		List<BoardInfo> boardList = null;
		
		if (totalSize > 0) {
			int from = pagerInfo.getStartRownum();
			int to = pagerInfo.getEndRownum();

			boardList = bo.getBoardList(id, (from - 1), (to - from + 1));
		}
		
		mav.addObject("boardList", boardList);
		mav.addObject("page", pagerInfo.getPage());
		
		return mav;
	}
	
	@RequestMapping("/xml/{id}.nhn")
	public ModelAndView myListXML(HttpServletRequest req, @PathVariable String id, @RequestParam(value="page", required=true, defaultValue="1") String page) throws Exception {
		ModelAndView mav = new ModelAndView("jaxb2View");
		mav.addObject("id", id);
		
		int totalSize = bo.getBoardCount(id);
		PagerInfo pagerInfo = new PagerInfo(req, "my", totalSize);
		pagerInfo.setPage(Integer.parseInt(page));
		pagerInfo.setQueryString("id=" + id);
		
		List<BoardInfo> boardList = null;
		
		if (totalSize > 0) {
			int from = pagerInfo.getStartRownum();
			int to = pagerInfo.getEndRownum();

			boardList = bo.getBoardList(id, (from - 1), (to - from + 1));
		}
		
		mav.addObject("boardList", boardList);
		mav.addObject("page", pagerInfo.getPage());
		
		return mav;
	}
	
	@RequestMapping(value = "/register.nhn")
	public ModelAndView register(HttpServletResponse response, String id) throws Exception {
		response.setHeader("id", id);
		return new ModelAndView("/board/register");
	}
	
	@RequestMapping(value = "/registerSubmit.nhn", method = RequestMethod.POST)
	public View registerSubmit(@RequestParam(value = "attachFile", required = false) MultipartFile file, BoardInfo boardInfo, String id) throws Exception {
		if(file != null) {
			int lastIndex = file.getOriginalFilename().lastIndexOf(".");
			String extention = file.getOriginalFilename().substring(lastIndex);
			String saveFileName = id + "_" + String.valueOf(System.currentTimeMillis() + extention);
			
			FileUploadItem fileItem = new FileUploadItem(file.getName(), file);
			
			fileItem.setOriginalFilename(saveFileName);
			
			fileUploadManager.upload(new FileUploadItem[] { fileItem });
			boardInfo.setFileName(file.getOriginalFilename());
			boardInfo.setFileRealName(saveFileName);
		}
		
		bo.registerBoardInfo(boardInfo);
		
		AlertAndPostView view = new AlertAndPostView();
		view.setMessage("등록하였습니다.");
		view.setDestUrl("./list.nhn");
		view.addParam("id", id);
		
		return view;
	}
	
	@RequestMapping("/detail.nhn")
	public ModelAndView detail(String id, String seq) throws Exception {
		ModelAndView mav = new ModelAndView("/board/detail");
		mav.addObject("id", id);
		mav.addObject("boardInfo", bo.getBoardInfo(seq));
		
		return mav;
	}
	
	@RequestMapping(value = "/modify.nhn", method = RequestMethod.GET)
	public ModelAndView modify(String id, String seq) throws Exception {
		ModelAndView mav = new ModelAndView("/board/modify");
		mav.addObject("id", id);
		mav.addObject("boardInfo", bo.getBoardInfo(seq));
		
		return mav;
	}
	
	@RequestMapping(value = "/modifySubmit.nhn", method = RequestMethod.POST)
	public View modifySubmit(@RequestParam(value = "attachFile", required = false) MultipartFile file, BoardInfo boardInfo, String id) throws Exception {
		if(file.getSize() != 0) {
			int lastIndex = file.getOriginalFilename().lastIndexOf(".");
			String extention = file.getOriginalFilename().substring(lastIndex);
			String saveFileName = id + "_" + String.valueOf(System.currentTimeMillis() + extention);
			
			FileUploadItem fileItem = new FileUploadItem(file.getName(), file);
			
			fileItem.setOriginalFilename(saveFileName);
			
			fileUploadManager.upload(new FileUploadItem[] { fileItem });
			boardInfo.setFileName(file.getOriginalFilename());
			boardInfo.setFileRealName(saveFileName);
		}
		
		bo.updateBoardInfo(boardInfo);
		
		AlertAndPostView view = new AlertAndPostView();
		view.setMessage("수정하였습니다.");
		view.setDestUrl("./list.nhn");
		view.addParam("id", id);
		
		return view;
	}
	
	@RequestMapping("/delete.nhn")
	public View delete(String id, String seq) throws Exception {
		bo.deleteBoardInfo(seq);
		
		AlertAndPostView view = new AlertAndPostView();
		view.setMessage("삭제하였습니다.");
		view.setDestUrl("./list.nhn");
		view.addParam("id", id);
		
		return view;
	}
	
	@RequestMapping("/deleteFile.nhn")
	public ModelAndView deleteFile(String id, String seq) throws Exception {
		BoardInfo boardInfo = bo.getBoardInfo(seq);
		
		String fileName = boardInfo.getFileRealName();
		
		boardInfo.setFileName("");
		boardInfo.setFileRealName("");
		
		bo.updateBoardInfo(boardInfo);
		
		DataHandler dataHandler = DataHandlerFactory.getDataHandler();

		File file = new File(dataHandler.get("filepath") + fileName);

		if(file.exists()) {
			file.delete();
		}
		
		return new ModelAndView("jsonView");
	}
}
