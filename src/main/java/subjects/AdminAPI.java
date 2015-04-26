package subjects;

import service.OfyService;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.googlecode.objectify.Objectify;

import entities.*;

@Api(name = "adminapi", version = "v1", scopes = { Constants.EMAIL_SCOPE }, clientIds = {
		Constants.WEB_CLIENT_ID, Constants.API_EXPLORER_CLIENT_ID }, description = "Admin Api")
public class AdminAPI {
	@ApiMethod(name = "addFaculty", path = "faculty", httpMethod = HttpMethod.POST)
	public boolean addFaculty(String name){
		Faculty f=new Faculty(name);
		if (ofy().load().type(Faculty.class).filter("name = ", name).count()==0)
			ofy().save().entity(f).now();
		else 
			return false;
		return true;

	}
	@ApiMethod(name = "removeFaculty", path = "faculty", httpMethod = HttpMethod.POST)
	public boolean removeFaculty(String name){
		return false;

	}

	@ApiMethod(name = "getFaculties", path = "faculty", httpMethod = HttpMethod.POST)
	public boolean addDepartment(String name, String faculty_name){
		return false;

	}
	@ApiMethod(name = "removeDepartment", path = "department", httpMethod = HttpMethod.POST)
	public boolean removeDepartment(String name){
		return false;

	}
	@ApiMethod(name = "addSubject", path = "subject", httpMethod = HttpMethod.POST)
	public boolean addSubject(String name, String faculty_name){
		return false;

	}
	@ApiMethod(name = "removeSubject", path = "subject", httpMethod = HttpMethod.POST)
	public boolean removeSubject(long id){
		return false;

	}
	@ApiMethod(name = "addSpeciality", path = "speciality", httpMethod = HttpMethod.POST)
	public boolean addSpeciality(String name, String faculty_name){
		return false;

	}
	@ApiMethod(name = "removeSpeciality", path = "speciality", httpMethod = HttpMethod.POST)
	public boolean removeSpeciality(String name){
		return false;

	}
	@ApiMethod(name = "setProfessional", path = "professional", httpMethod = HttpMethod.POST)
	public boolean setProfessional( String speciality_name ,Long subject_id, boolean value){
		return false;

	}

	private static Objectify ofy() {
		return OfyService.ofy();
	}
}
