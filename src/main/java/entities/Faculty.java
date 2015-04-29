package entities;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
@Entity
public class Faculty {
	public Faculty() {
		// TODO Auto-generated constructor stub
	}
	@Id
	private String name;

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
