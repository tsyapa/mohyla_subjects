package subjects;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class DB {
	HashMap<Long, Department> departmentMap;
	HashMap<Long, Speciality> specialityMap;
	HashMap<Long, Faculty> facultyMap;
	HashMap<Long, Profile> profileMap;
	HashMap<String, Profile> profileMapByLogin;
	HashMap<Long, Subject> subjectMap;
	HashMap<Long, Enrolling> enrollingMapBySubject;
	HashMap<Long, Enrolling> enrollingMapByProfile;
	HashMap<Long, Enrolling> enrollingMap;
	HashMap<Long, Professional> professionalMapBySubject;
	HashMap<Long, Professional> professionalMapBySpeciality;
	HashMap<Long, Professional> professionalMap;
	HashSet<Long> ids;
	public long generateID() {
		long l;
		do{
			 l = new Random().nextLong(); 
		}while(ids.contains(l));
		return l;
	}

	public boolean addDepartment(String name,long faculty_id){
		try{
			new Department(this,name, faculty_id);
			return true;
		}catch(InvalidIndexException e){return false;}
	}
	public boolean addEnrolling(long subject_id, long profile_id){
		try{
			new Enrolling(this,subject_id, profile_id);
			return true;
		}catch(InvalidIndexException e){return false;}
	}

}
