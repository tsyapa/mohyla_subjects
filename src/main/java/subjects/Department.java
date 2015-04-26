package subjects;

public class Department {
	String name;
	long faculty_id;
	Long id;
	public Department(DB db, String name, long faculty_id) throws InvalidIndexException {
		if (db.facultyMap.containsKey(faculty_id)){
			this.faculty_id = faculty_id;
			this.name=name;
			id = db.generateID();
			db.departmentMap.put(id, this);
		}else throw new InvalidIndexException();
	}
}
