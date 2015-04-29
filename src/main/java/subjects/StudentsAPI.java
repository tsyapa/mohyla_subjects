package subjects;

import javax.inject.Named;


public class StudentsAPI {
	public boolean enroll(@Named("token")String token, @Named("token")long profile_id, @Named("token")long subject_id,@Named("token") boolean value){
		
		return false;
		
	}
	public boolean rate(@Named("token")String token,@Named("token")long profile_id,@Named("token") long subject_id, @Named("token")int rating){
		
		return false;
		
	}
}
