package subjects;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import service.OfyService;

import com.google.api.server.spi.config.Api;
import com.googlecode.objectify.Objectify;

import entities.*;
@Api(name = "profileapi", version = "v1", scopes = { Constants.EMAIL_SCOPE }, clientIds = {
		Constants.WEB_CLIENT_ID, Constants.API_EXPLORER_CLIENT_ID }, description = "Public Api")

public class ProfileAPI {
	public Message addProfile(String name, String login, String password,String passwordconfirm,
			String speciality_name) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		if (password.equals(passwordconfirm)){
			Profile f=new Profile(name, login, md5(password), speciality_name);
			ofy().save().entity(f).now();
			return new Message(md5(password));
		}
		else{
			return new Message("Passwords don't match!");
		}
	}
	public Message login(String login, String password) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		PublicViewAPI api = new PublicViewAPI();
		Profile profile = api.getProfileByLogin(login);
		if(profile!=null&&profile.getPasshash().equals(md5(password))){
			return new Message(md5(password));
		}else{
			return new Message("fail");
		}
	}
	private String md5(String yourString) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		byte[] bytesOfMessage = yourString.getBytes("UTF-8");

		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] thedigest = md.digest(bytesOfMessage);
		return bytesToHex(thedigest);
	}

	private static Objectify ofy() {
		return OfyService.ofy();
	}
	final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();
	private static String bytesToHex(byte[] bytes) {
		char[] hexChars = new char[bytes.length * 2];
		for ( int j = 0; j < bytes.length; j++ ) {
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}
}
