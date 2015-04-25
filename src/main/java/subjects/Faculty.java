package subjects;

public class Faculty {
	String name;
	long id;
	public Faculty(DB db, String name) throws InvalidIndexException {
			this.name=name;
			id = db.generateID();
			db.facultyMap.put(id, this);
	}
}
