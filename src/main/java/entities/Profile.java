package entities;

import com.googlecode.objectify.annotation.Id;

import subjects.DB;
import subjects.InvalidIndexException;
import subjects.Utils;

public class Profile {
	String name;
	@Id
	String login;
	String passhash;
	long speciality_id;
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
	public long getSpeciality_id() {
		return speciality_id;
	}
	public void setSpeciality_id(long speciality_id) {
		this.speciality_id = speciality_id;
	}
	public Profile(String name, String login, String passhash,
			long speciality_id) {
		super();
		this.name = name;
		this.login = login;
		this.passhash = passhash;
		this.speciality_id = speciality_id;
	}
	
}
