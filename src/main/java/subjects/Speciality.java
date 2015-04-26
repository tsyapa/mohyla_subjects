package subjects;

public class Speciality {
	String name;
	long faculty_id;
	long id;
	public Speciality(DB db, String name,  long faculty_id) throws InvalidIndexException {
		if (db.facultyMap.containsKey(faculty_id)){
			this.name=name;
			this.faculty_id=faculty_id;
			id = db.generateID();
			db.specialityMap.put(id, this);
		}else throw new InvalidIndexException();
	}
}