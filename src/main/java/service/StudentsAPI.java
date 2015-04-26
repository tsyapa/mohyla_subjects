package service;

import subjects.InvalidIndexException;

public class StudentsAPI {
	public boolean enroll(long profile_id, long subject_id){
		
		return false;
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
