package subjects;

public class Enrolling {
	long subject_id;
	long profile_id;
	long id;
	public Enrolling(DB db, long subject_id, long profile_id) throws InvalidIndexException {
		if (db.subjectMap.containsKey(subject_id)&&db.profileMap.containsKey(profile_id)){
			this.subject_id = subject_id;
			this.profile_id=profile_id;
			id = db.generateID();
			db.enrollingMap.put(id, this);
			db.enrollingMapByProfile.put(profile_id, this);
			db.enrollingMapBySubject.put(subject_id, this);
		}else throw new InvalidIndexException();
	}
}
