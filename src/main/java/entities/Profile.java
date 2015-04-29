package entities;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
@Entity
public class Profile {
	public Profile() {
		// TODO Auto-generated constructor stub
	}
	private String name;
	@Id
	private String login;
	private String passhash;
	private String speciality_name;
	private String faculty_name;
	private int year;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPasshash() {
		return passhash;
	}
	public void setPasshash(String passhash) {
		this.passhash = passhash;
	}
	public String getSpeciality_name() {
		return speciality_name;
	}
	public void setSpeciality_name(String speciality_name) {
		this.speciality_name = speciality_name;
	}
	public String getFaculty_name() {
		return faculty_name;
	}
	public void setFaculty_name(String faculty_name) {
		this.faculty_name = faculty_name;
	}
	
	public Profile(String name, String login, String passhash,
			String speciality_name) {
		super();
		this.name = name;
		this.login = login;
		this.passhash = passhash;
		this.speciality_name = speciality_name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
}
