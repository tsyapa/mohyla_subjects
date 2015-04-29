package entities;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
@Entity
public class Professional {
	public Professional() {
		// TODO Auto-generated constructor stub
	}
	private long subject_id;
	private String speciality_name;
	private boolean value;
	@Id
	private Long id;
	public long getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(long subject_id) {
		this.subject_id = subject_id;
	}
	public String getSpeciality_name() {
		return speciality_name;
	}
	public void setSpeciality_name(String speciality_name) {
		this.speciality_name = speciality_name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Professional(long subject_id, String speciality_name, boolean value, Long id) {
		super();
		this.subject_id = subject_id;
		this.speciality_name = speciality_name;
		this.id = id;
		this.value=value;
	}
	public boolean isValue() {
		return value;
	}
	public void setValue(boolean value) {
		this.value = value;
	}
	
}
