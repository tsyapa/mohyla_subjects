package entities;

import com.googlecode.objectify.annotation.Id;

import subjects.DB;

public class Faculty {
	@Id
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Faculty(String name) {
		super();
		this.name = name;
	}
	
}
