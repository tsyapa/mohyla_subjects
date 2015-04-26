package subjects;

import java.util.LinkedList;
import java.util.List;

import service.OfyService;

import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.cmd.Query;

import entities.Department;
import entities.Enrolling;
import entities.Faculty;
import entities.Professional;
import entities.Profile;
import entities.Speciality;
import entities.Subject;

public class PublicViewAPI {
	@ApiMethod(name = "getFaculties", path = "faculty/getAll", httpMethod = HttpMethod.POST)
	public List<Faculty> getFaculties(){
		Query <Faculty> query=ofy().load().type(Faculty.class);
		return query.list();
	}
	public List<Department> getAllSubjects(){
		Query <Department> query=ofy().load().type(Department.class);
		return query.list();
	}
	public List<Subject> getSubjectsByDepartment(String department_name){
		Query <Subject> query=ofy().load().type(Subject.class);
		query=query.filter("department_name = ", department_name);
		return query.list();
	}
	public List<Subject> getSubjectsBySpeciality(String speciality_name){
		Query <Professional> query=ofy().load().type(Professional.class);
		query=query.filter("speciality_name = ", speciality_name);
		List<Professional> list = query.list();
		List<Subject> list2 = new LinkedList<Subject>();
		for(Professional professional :  list){
//			Query <Subject> query2=ofy().load().type(Subject.class);
//			query2=query2.filter("subject_id = ", professional.getSubject_id());
//			list2.add(query2.first().safe());
		}
		return list2;
	}
	public List<Subject> getSubjectsByFaculty(String faculty_name){
		Query <Department> query=ofy().load().type(Department.class);
		query=query.filter("faculty_name = ", faculty_name);
		List<Department> list = query.list();
		List<Subject> list2 = new LinkedList<Subject>();
		for(Department department :  list){
			Query <Subject> query2=ofy().load().type(Subject.class);
			query2=query2.filter("department_name = ", department.getName());
			list2.addAll(query2.list());
		}
		return list2;
	}
	public List<Subject> getSubjectsByProfile( String profile_login){
		Query <Enrolling> query=ofy().load().type(Enrolling.class);
		query=query.filter("profile_login = ", profile_login);
		List<Enrolling> list = query.list();
		List<Subject> list2 = new LinkedList<Subject>();
		for(Enrolling enrolling :  list){
//			Query <Subject> query2=ofy().load().type(Subject.class);
//			query2=query2.filter("subject_id = ", enrolling.getSubject_id());
//			list2.add(query2.first().safe());
		}
		return list2;
		
	}
	public List<Department> getDepartments(String faculty_name){
		Query<Department> query=ofy().load().type(Department.class);
		query=query.filter("faculty_name = ", faculty_name);
		return query.list();
	}
	public List<Speciality> getAllSpecialities(){
		Query <Speciality> query=ofy().load().type(Speciality.class);
		return query.list();
	}
	public List<Speciality> getSpecialitiesBySubject( Long subject_id){
		Query <Professional> query=ofy().load().type(Professional.class);
		query=query.filter("subject_id = ", subject_id);
		List<Professional> list = query.list();
		List<Speciality> list2 = new LinkedList<Speciality>();
		for(Professional professional :  list){
//			Query <Speciality> query2=ofy().load().type(Speciality.class);
//			query2=query2.filter("speciality_name = ", professional.getSpeciality_name());
//			list2.add(query2.first().safe());
		}
		return list2;
	}
	public List<Speciality> getSpecialitiesByFaculty( String faculty_name){
		Query<Speciality> query=ofy().load().type(Speciality.class);
		query=query.filter("faculty_name = ", faculty_name);
		return query.list();
	}
	public boolean isProfessional( String speciality_name , Long subject_id){
		Query<Professional> query=ofy().load().type(Professional.class);
		query=query.filter("speciality_name = ", speciality_name);
		query=query.filter("subject_id = ", subject_id);
		return query.count()==1;
	}
	public List<Profile> getProfilesBySubject(Long subject_id){
		Query <Enrolling> query=ofy().load().type(Enrolling.class);
		query=query.filter("subject_id = ", subject_id);
		List<Enrolling> list = query.list();
		List<Profile> list2 = new LinkedList<Profile>();
		for(Enrolling enrolling :  list){
//			Query <Profile> query2=ofy().load().type(Profile.class);
//			query2=query2.filter("profile_login = ", enrolling.getProfile_login());
//			list2.add(query2.first().safe());
		}
		return list2;
	}
	private static Objectify ofy() {
		return OfyService.ofy();
	}
}
