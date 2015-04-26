package subjects;


public class Subject {
	String name;
	String lector;
	double credits;
	int trimester;
	String description;
	long department_id;
	long id;
	public Subject(DB db, String name, String lector, double credits, int trimester, String description, long department_id) throws InvalidIndexException {
		if (db.departmentMap.containsKey(department_id)){
			this.name=name;
			this.lector=lector;
			this.credits=credits;
			this.trimester=trimester;
			this.description=description;
			this.department_id=department_id;
			id = db.generateID();
			db.subjectMap.put(id, this);
		}else throw new InvalidIndexException();
	}
}
