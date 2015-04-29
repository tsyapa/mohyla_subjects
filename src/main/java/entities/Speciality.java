package entities;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
@Entity
public class Speciality {
	public Speciality() {
		// TODO Auto-generated constructor stub
	}
	@Id
	private String name;
	private String faculty_name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFaculty_name() {
		return faculty_name;
	}
	public void setFaculty_name(String faculty_name) {
		this.faculty_name = faculty_name;
	}
	public Speciality(String name, String faculty_name) {
		super();
		this.name = name;
		this.faculty_name = faculty_name;
	}
	
}