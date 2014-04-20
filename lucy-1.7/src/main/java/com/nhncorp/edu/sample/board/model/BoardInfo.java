package com.nhncorp.edu.sample.board.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="boardInfo")
public class BoardInfo {
	private int seq;
	private String title;
	private String content;
	private String writeId;
	private String writeName;
	private String registerYmdt;
	private String fileRealName;
	private String fileName;

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriteId() {
		return writeId;
	}

	public void setWriteId(String writeId) {
		this.writeId = writeId;
	}

	public String getWriteName() {
		return writeName;
	}

	public void setWriteName(String writeName) {
		this.writeName = writeName;
	}

	public String getRegisterYmdt() {
		return registerYmdt;
	}

	public void setRegisterYmdt(String registerYmdt) {
		this.registerYmdt = registerYmdt;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileRealName() {
		return fileRealName;
	}

	public void setFileRealName(String fileRealName) {
		this.fileRealName = fileRealName;
	}
}
