package service;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

import entities.Department;
import entities.Enrolling;
import entities.Faculty;
import entities.Professional;
import entities.Profile;
import entities.Rate;
import entities.Speciality;
import entities.Subject;

public class OfyService {

    static {
        factory().register(Department.class);
        factory().register(Enrolling.class);
        factory().register(Faculty.class);
        factory().register(Professional.class);
        factory().register(Profile.class);
        factory().register(Rate.class);
        factory().register(Speciality.class);
        factory().register(Subject.class);
    }

    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }

    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }
}