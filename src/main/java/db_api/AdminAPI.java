package db_api;

import entities.*;

public class AdminAPI {
	public boolean addFaculty(String name){
		return false;
		
	}
	public boolean removeFaculty(String name){
		return false;
		
	}
	public Faculty[] getFaculties(){
		return null;
		
	}
	public boolean addDepartment(String name, String faculty_name){
		return false;
		
	}
	public boolean removeDepartment(String name){
		return false;
		
	}
	public Department[] getDepartments(String faculty_name){
		return null;
	}
	public boolean addSubject(String name, String faculty_name){
		return false;
		
	}
	public boolean removeSubject(long id){
		return false;
		
	}
	public Department[] getAllSubjects(){
		return null;
	}
	public Department[] getSubjectsByDepartment(String department_name){
		return null;
	}
	public Department[] getSubjectsBySpeciality(String speciality_name){
		return null;
	}
	public Department[] getSubjectsByFaculty(String faculty_name){
		return null;
	}
	public Department[] getSubjectsByProfile( String profile_login){
		return null;
	}
	public boolean addSpeciality(String name, String faculty_name){
		return false;
		
	}
	public boolean removeSpeciality(String name){
		return false;
		
	}
	public Speciality[] getAllSpecialities(){
		return null;
	}
	public Speciality[] getSpecialities( Long subject_id){
		return null;
	}
	public Speciality[] getSpecialities( String faculty_name){
		return null;
	}
	public boolean setProfessional( String speciality_name ,Long subject_id, boolean value){
		return false;
		
	}
	public boolean isProfessional( String speciality_name ,Long subject_id){
		return false;
		
	}
}
