package subjects;

public class Profile {
	String name;
	String login;
	String passhash;
	long speciality_id;
	Long id;
	public Profile(DB db, String name, String login,String password,  long speciality_id) throws InvalidIndexException {
		if (db.specialityMap.containsKey(speciality_id)&&!db.profileMapByLogin.containsKey(login)){
			this.name=name;
			this.login=login;
			this.passhash=Utils.md5(password);
			this.speciality_id=speciality_id;
			id = db.generateID();
			db.profileMap.put(id, this);
			db.profileMapByLogin.put(login, this);
		}else throw new InvalidIndexException();
	}
}
