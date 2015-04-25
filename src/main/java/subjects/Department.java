package subjects;

public class Department {
	String name;
	long faculty_id;
	long id;
	public Department(DB db, String name, long faculty) throws InvalidIndexException {
		if (db.facultyMap.containsKey(faculty)){
			faculty_id = faculty;
			this.name=name;
			id = db.generateID();
			db.departmentMap.put(id, this);
		}else throw new InvalidIndexException();
	}
}
