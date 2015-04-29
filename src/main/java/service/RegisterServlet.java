package service;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			String name=req.getParameter("name");
			String login=req.getParameter("login");
			String password=req.getParameter("password");
			String password_confirm=req.getParameter("password_confirm");
			String speciality_name=req.getParameter("speciality_name");
			
			String string = new subjects.ProfileAPI().addProfile(name, login, password, password_confirm, speciality_name).message;
			if (!string.equals("fail")){
				System.out.println("ok");
				resp.addCookie(new Cookie("id", string));
				resp.addCookie(new Cookie("user", req.getParameter("login")));
			}else{
				System.err.println("fail");
				resp.sendRedirect("/login.html");
			}
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		resp.setStatus(200);
	}
}
