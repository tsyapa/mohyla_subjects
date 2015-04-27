package subjects;

import java.util.Random;

import javax.inject.Named;

import service.OfyService;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;

import entities.*;

@Api(name = "adminapi", version = "v1", scopes = { Constants.EMAIL_SCOPE }, clientIds = {
		Constants.WEB_CLIENT_ID, Constants.API_EXPLORER_CLIENT_ID }, description = "Admin Api")
public class AdminAPI {
	private static Random random = new Random();

	public static long generateID() {
		return random.nextLong();
	}
	@ApiMethod(name = "addFaculty", path = "facultyadd", httpMethod = HttpMethod.POST)
	public Message addFaculty(@Named("name")String name){
		Faculty f=new Faculty(name);
		ofy().save().entity(f).now();
		return new Message("Faculty created");
	}
	@ApiMethod(name = "removeFaculty", path = "facultydel", httpMethod = HttpMethod.POST)
	public Message removeFaculty(@Named("name")String name){
		ofy().delete().key(Key.create(Faculty.class, name));
		return new Message("Faculty removed");
	}

	@ApiMethod(name = "getDepartments", path = "departmentadd", httpMethod = HttpMethod.POST)
	public Message addDepartment(@Named("name")String name, @Named("faculty_name")String faculty_name){
		Department f=new Department(name, faculty_name);
		ofy().save().entity(f).now();
		return new Message("Department created");
	}
	@ApiMethod(name = "removeDepartment", path = "department", httpMethod = HttpMethod.POST)
	public Message removeDepartment(@Named("name")String name){
		ofy().delete().key(Key.create(Department.class, name));
		return new Message("Department removed");
	}
	@ApiMethod(name = "addSubject", path = "subjectadd", httpMethod = HttpMethod.POST)
	public Message addSubject(@Named("name")String name,@Named("faculty_name") String faculty_name, @Named("lector")String lector,@Named("credits") double credits, @Named("trimester")int trimester,@Named("description") String description,@Named("department_id") long department_id){
		Subject f=new Subject(faculty_name, lector, credits, trimester, description, department_id, generateID());
		ofy().save().entity(f).now();
		return new Message("Subject created");
	}
	@ApiMethod(name = "removeSubject", path = "subjectdel", httpMethod = HttpMethod.POST)
	public Message removeSubject(@Named("name")long id){
		ofy().delete().key(Key.create(Subject.class, id));
		return new Message("Subject removed");

	}
	@ApiMethod(name = "addSpeciality", path = "specialityadd", httpMethod = HttpMethod.POST)
	public Message addSpeciality(@Named("name")String name, @Named("faculty_name")String faculty_name){
		Speciality f=new Speciality(name, faculty_name);
		ofy().save().entity(f).now();
		return new Message("Speciality created");
	}
	@ApiMethod(name = "removeSpeciality", path = "specialitydel", httpMethod = HttpMethod.POST)
	public Message removeSpeciality(@Named("name")String name){
		ofy().delete().key(Key.create(Speciality.class, name));
		return new Message("Speciality removed");
	}
	@ApiMethod(name = "setProfessional", path = "professionalset", httpMethod = HttpMethod.POST)
	public Message setProfessional( @Named("speciality_name")String speciality_name ,@Named("subject_id")long subject_id, @Named("value")boolean value){
		Professional f=new Professional(subject_id, speciality_name, value, generateID());
		ofy().save().entity(f).now();
		return new Message("Subject set as professional for speciality");
	}
	private static Objectify ofy() {
		return OfyService.ofy();
	}
}
