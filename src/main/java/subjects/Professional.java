package subjects;

public class Professional {
	long subject_id;
	long speciality_id;
	Long id;
	public Professional(DB db, long subject_id, long speciality_id) throws InvalidIndexException {
		if (db.subjectMap.containsKey(subject_id)&&db.specialityMap.containsKey(speciality_id)){
			this.subject_id=subject_id;
			this.speciality_id=speciality_id;
			id = db.generateID();
			db.professionalMap.put(id, this);
			db.professionalMapBySpeciality.put(speciality_id, this );
			db.professionalMapBySubject.put(subject_id, this);
		}else throw new InvalidIndexException();
	}
}
