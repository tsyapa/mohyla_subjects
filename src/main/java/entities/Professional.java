package entities;

import com.googlecode.objectify.annotation.Id;

import subjects.DB;
import subjects.InvalidIndexException;

public class Professional {
	long subject_id;
	long speciality_id;
	@Id
	Long id;
	public long getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(long subject_id) {
		this.subject_id = subject_id;
	}
	public long getSpeciality_id() {
		return speciality_id;
	}
	public void setSpeciality_id(long speciality_id) {
		this.speciality_id = speciality_id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Professional(long subject_id, long speciality_id, Long id) {
		super();
		this.subject_id = subject_id;
		this.speciality_id = speciality_id;
		this.id = id;
	}
	
}
