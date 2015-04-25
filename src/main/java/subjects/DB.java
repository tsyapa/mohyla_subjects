package subjects;

import java.util.HashMap;

public class DB {
	HashMap<Long, Department> departmentMap;
	HashMap<Long, Speciality> specialityMap;
	HashMap<Long, Faculty> facultyMap;
	HashMap<Long, Profile> profileMap;
	HashMap<Long, Subject> subjectMap;
	HashMap<Long, Enrolling> enrollingMapBySubject;
	HashMap<Long, Enrolling> enrollingMapByProfile;
	HashMap<Long, Enrolling> enrollingMap;
	HashMap<Long, Proffessional> proffessionalMapBySubject;
	HashMap<Long, Proffessional> proffessionalMapBySpeciality;
	public long generateID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
