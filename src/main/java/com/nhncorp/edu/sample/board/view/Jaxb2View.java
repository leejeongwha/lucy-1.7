package com.nhncorp.edu.sample.board.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.stream.StreamResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.servlet.View;

import com.nhncorp.edu.sample.board.model.BoardInfo;
import com.nhncorp.edu.sample.board.model.BoardInfoList;

public class Jaxb2View implements View {
	
	@Autowired
	private Jaxb2Marshaller jaxb2Marshaller;

	@Override
	public String getContentType() {
		return "text/xml;charset=utf-8";
	}

	@SuppressWarnings("unchecked")
	@Override
	public void render(Map<String, ?> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(model == null) {
			return;
		}

		response.setContentType(getContentType());
		
		List<BoardInfo> list = (List<BoardInfo>) model.get("boardList");
		
		BoardInfoList bil = new BoardInfoList();
		bil.setList(list);
		
		StreamResult sr = new StreamResult(response.getOutputStream());
		
		jaxb2Marshaller.marshal(bil, sr);
	}

}
