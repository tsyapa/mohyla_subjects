package entities;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
@Entity
public class Department {
	@Id
	String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getFaculty_id() {
		return faculty_id;
	}
	public void setFaculty_id(long faculty_id) {
		this.faculty_id = faculty_id;
	}
	long faculty_id;
	public Department(String name, long faculty_id) {
		super();
		this.name = name;
		this.faculty_id = faculty_id;
	}
}
