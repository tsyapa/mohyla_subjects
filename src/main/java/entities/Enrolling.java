package entities;

import com.googlecode.objectify.annotation.Id;

import subjects.DB;
import subjects.InvalidIndexException;

public class Enrolling {
	long subject_id;
	long profile_id;
	@Id
	long id;
	public long getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(long subject_id) {
		this.subject_id = subject_id;
	}
	public long getProfile_id() {
		return profile_id;
	}
	public Enrolling(long subject_id, long profile_id, long id) {
		super();
		this.subject_id = subject_id;
		this.profile_id = profile_id;
		this.id = id;
	}
	public void setProfile_id(long profile_id) {
		this.profile_id = profile_id;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
