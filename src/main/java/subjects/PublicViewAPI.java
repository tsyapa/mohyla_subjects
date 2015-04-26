package subjects;

import java.util.LinkedList;
import java.util.List;

import service.OfyService;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.cmd.Query;

import entities.*;
//@Api(name = "publicviewapi", version = "v1", scopes = { Constants.EMAIL_SCOPE }, clientIds = {
//		Constants.WEB_CLIENT_ID, Constants.API_EXPLORER_CLIENT_ID }, description = "Admin Api")

public class PublicViewAPI {
	@ApiMethod(name = "getFaculties", path = "faculty", httpMethod = HttpMethod.POST)
	public List<Faculty> getFaculties(){
		Query <Faculty> query=ofy().load().type(Faculty.class);
		return query.list();
	}
	@ApiMethod(name = "getAllSubjects", path = "subject", httpMethod = HttpMethod.POST)
	public List<Department> getAllSubjects(){
		Query <Department> query=ofy().load().type(Department.class);
		return query.list();
	}
	@ApiMethod(name = "getSubjectsByDepartment", path = "subject", httpMethod = HttpMethod.POST)
	public List<Subject> getSubjectsByDepartment(String department_name){
		Query <Subject> query=ofy().load().type(Subject.class);
		query=query.filter("department_name = ", department_name);
		return query.list();
	}
	@ApiMethod(name = "getSubjectsBySpeciality", path = "subject", httpMethod = HttpMethod.POST)
	public List<Subject> getSubjectsBySpeciality(String speciality_name){
		Query <Professional> query=ofy().load().type(Professional.class);
		query=query.filter("speciality_name = ", speciality_name);
		List<Professional> list = query.list();
		List<Subject> list2 = new LinkedList<Subject>();
		for(Professional professional :  list){
			list2.add(ofy().load().key(Key.create(Subject.class,professional.getSubject_id())).now());
		}
		return list2;
	}
	@ApiMethod(name = "getSubjectsByFaculty", path = "subject", httpMethod = HttpMethod.POST)
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
	@ApiMethod(name = "getSubjectsByProfile", path = "subject", httpMethod = HttpMethod.POST)
	public List<Subject> getSubjectsByProfile( String profile_login){
		Query <Enrolling> query=ofy().load().type(Enrolling.class);
		query=query.filter("profile_login = ", profile_login);
		List<Enrolling> list = query.list();
		List<Subject> list2 = new LinkedList<Subject>();
		for(Enrolling enrolling :  list){
			list2.add(ofy().load().key(Key.create(Subject.class, enrolling.getSubject_id())).now());
		}
		return list2;
		
	}
	@ApiMethod(name = "getDepartments", path = "department", httpMethod = HttpMethod.POST)
	public List<Department> getDepartments(String faculty_name){
		Query<Department> query=ofy().load().type(Department.class);
		query=query.filter("faculty_name = ", faculty_name);
		return query.list();
	}
	@ApiMethod(name = "getAllSpecialities", path = "speciality", httpMethod = HttpMethod.POST)
	public List<Speciality> getAllSpecialities(){
		Query <Speciality> query=ofy().load().type(Speciality.class);
		return query.list();
	}
	@ApiMethod(name = "getSpecialitiesBySubject", path = "speciality", httpMethod = HttpMethod.POST)
	public List<Speciality> getSpecialitiesBySubject( Long subject_id){
		Query <Professional> query=ofy().load().type(Professional.class);
		query=query.filter("subject_id = ", subject_id);
		List<Professional> list = query.list();
		List<Speciality> list2 = new LinkedList<Speciality>();
		for(Professional professional :  list){
			list2.add(ofy().load().key(Key.create(Speciality.class, professional.getSpeciality_name())).now());
		}
		return list2;
	}
	@ApiMethod(name = "getSpecialitiesByFaculty", path = "speciality", httpMethod = HttpMethod.POST)
	public List<Speciality> getSpecialitiesByFaculty( String faculty_name){
		Query<Speciality> query=ofy().load().type(Speciality.class);
		query=query.filter("faculty_name = ", faculty_name);
		return query.list();
	}
	@ApiMethod(name = "isProfessional", path = "professional", httpMethod = HttpMethod.POST)
	public boolean isProfessional( String speciality_name , Long subject_id){
		Query<Professional> query=ofy().load().type(Professional.class);
		query=query.filter("speciality_name = ", speciality_name);
		query=query.filter("subject_id = ", subject_id);
		return query.count()==1;
	}
	@ApiMethod(name = "getProfilesBySubject", path = "profile", httpMethod = HttpMethod.POST)
	public List<Profile> getProfilesBySubject(Long subject_id){
		Query <Enrolling> query=ofy().load().type(Enrolling.class);
		query=query.filter("subject_id = ", subject_id);
		List<Enrolling> list = query.list();
		List<Profile> list2 = new LinkedList<Profile>();
		for(Enrolling enrolling :  list){
			list2.add(ofy().load().key(Key.create(Profile.class, enrolling.getProfile_login())).now());
		}
		return list2;
	}
	private static Objectify ofy() {
		return OfyService.ofy();
	}
}
