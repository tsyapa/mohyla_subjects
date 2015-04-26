package subjects;

public class Faculty {
	String name;
	long id;
	public Faculty(DB db, String name){
			this.name=name;
			id = db.generateID();
			db.facultyMap.put(id, this);
	}
}
