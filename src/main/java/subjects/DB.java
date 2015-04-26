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

	public boolean addFaculty(String name){
		new Faculty(this,name);
		return true;
		//завжди повертає істину, бо в нас нема параметра, який може бути некоректним
	}

	public boolean addProfessional(long subject_id, long speciality_id){
		try{
			new Professional(this,subject_id, speciality_id);
			return true;
		}catch(InvalidIndexException e){return false;}
	}
	public boolean addProfile(String name, String login,String password,  long speciality_id){
		try{
			new Profile(this,name, login,password ,speciality_id);
			return true;
		}catch(InvalidIndexException e){return false;}
	}
	public boolean addSpeciality(String name,  long faculty_id){
		try{
			new Speciality(this,name, faculty_id);
			return true;
		}catch(InvalidIndexException e){return false;}
	}
	public boolean addSubject(String name, String lector, double credits, int trimester, String description, long department_id){
		try{
			new Subject(this, name,  lector,  credits,  trimester,  description,  department_id);
			return true;
		}catch(InvalidIndexException e){return false;}
	}
}
