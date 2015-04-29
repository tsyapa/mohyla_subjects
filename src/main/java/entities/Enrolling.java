package entities;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
@Entity
public class Enrolling {
	public Enrolling() {
		// TODO Auto-generated constructor stub
	}
	private long subject_id;
	private String profile_login;
	@Id
	private long id;
	public long getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(long subject_id) {
		this.subject_id = subject_id;
	}
	public String getProfile_login() {
		return profile_login;
	}
	public void setProfile_login(String profile_login) {
		this.profile_login = profile_login;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Enrolling(long subject_id, String profile_login, long id) {
		super();
		this.subject_id = subject_id;
		this.profile_login = profile_login;
		this.id = id;
	}
}
