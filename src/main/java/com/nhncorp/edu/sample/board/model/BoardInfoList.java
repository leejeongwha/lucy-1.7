package com.nhncorp.edu.sample.board.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "boardInfoList")
public class BoardInfoList {
	private List<BoardInfo> list;

	public List<BoardInfo> getList() {
		if(list == null) {
			list = new ArrayList<BoardInfo>();
		}
		return list;
	}

	public void setList(List<BoardInfo> list) {
		this.list = list;
	}
}
