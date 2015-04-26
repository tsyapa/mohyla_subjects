package entities;

import com.googlecode.objectify.annotation.Id;

import subjects.DB;
import subjects.InvalidIndexException;

public class Speciality {
	@Id
	String name;
	long faculty_id;
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
	public Speciality(String name, long faculty_id) {
		super();
		this.name = name;
		this.faculty_id = faculty_id;
	}
	
}