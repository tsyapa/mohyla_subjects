package subjects;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;

import entities.Department;
import entities.Enrolling;
import entities.Faculty;
import entities.Professional;
import entities.Profile;
import entities.Speciality;
import entities.Subject;

public class DB {
DatastoreService service = DatastoreServiceFactory.getDatastoreService();
	HashMap<Long, Department> departmentMap;
	HashMap<Long, Speciality> specialityMap;
	HashMap<Long, Faculty> facultyMap;
	HashMap<Long, Profile> profileMap;
	HashMap<String, Profile> profileMapByLogin;
	HashMap<Long, Subject> subjectMap;
	HashMap<Long, HashSet<Subject>> subjectMapByDepartment;
	HashMap<Long, HashSet<Enrolling>> enrollingMapBySubject;
	HashMap<Long, HashSet<Enrolling>> enrollingMapByProfile;
	HashMap<Long, Enrolling> enrollingMap;
	HashMap<Long, HashSet<Professional>> professionalMapBySubject;
	HashMap<Long, HashSet<Professional>> professionalMapBySpeciality;
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
	public long[] removeDepartment(long id){
		try{
		}catch(InvalidIndexException e){return false;}
	}
	public boolean removeEnrolling(long subject_id, long profile_id){
		try{
			new Enrolling(this,subject_id, profile_id);
			return true;
		}catch(InvalidIndexException e){return false;}
	}

	public boolean removeFaculty(String name){
		new Faculty(this,name);
		return true;
		//завжди повертає істину, бо в нас нема параметра, який може бути некоректним
	}

	public boolean removeProfessional(long subject_id, long speciality_id){
		try{
			new Professional(this,subject_id, speciality_id);
			return true;
		}catch(InvalidIndexException e){return false;}
	}
	public boolean removeProfile(String name, String login,String password,  long speciality_id){
		try{
			new Profile(this,name, login,password ,speciality_id);
			return true;
		}catch(InvalidIndexException e){return false;}
	}
	public boolean removeSpeciality(String name,  long faculty_id){
		try{
			new Speciality(this,name, faculty_id);
			return true;
		}catch(InvalidIndexException e){return false;}
	}
	public boolean removeSubject(String name, String lector, double credits, int trimester, String description, long department_id){
		try{
			new Subject(this, name,  lector,  credits,  trimester,  description,  department_id);
			return true;
		}catch(InvalidIndexException e){return false;}
	}
}
