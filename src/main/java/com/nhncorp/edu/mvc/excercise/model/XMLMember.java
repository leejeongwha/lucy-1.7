package com.nhncorp.edu.mvc.excercise.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Member")
public class XMLMember {
	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
