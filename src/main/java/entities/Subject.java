package entities;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Subject {
	private String name;
	private String lector;
	private double credits;
	private int trimester;
	private String description;
	private String mustknow;
	private long department_id;
	@Id
	private Long id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLector() {
		return lector;
	}
	public void setLector(String lector) {
		this.lector = lector;
	}
	public double getCredits() {
		return credits;
	}
	public void setCredits(double credits) {
		this.credits = credits;
	}
	public int getTrimester() {
		return trimester;
	}
	public void setTrimester(int trimester) {
		this.trimester = trimester;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(long department_id) {
		this.department_id = department_id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Subject(String name, String lector, double credits, int trimester,
			String description, long department_id, Long id) {
		super();
		this.name = name;
		this.lector = lector;
		this.credits = credits;
		this.trimester = trimester;
		this.description = description;
		this.department_id = department_id;
		this.id = id;
	}
	public String getMustknow() {
		return mustknow;
	}
	public void setMustknow(String mustknow) {
		this.mustknow = mustknow;
	}
}
