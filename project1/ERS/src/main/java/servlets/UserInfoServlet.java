package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.User;
import services.UserService;
import utils.CorsFix;

public class UserInfoServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserService us = new UserService();
	private ObjectMapper om = new ObjectMapper();


	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		CorsFix.addCorsHeader(req.getRequestURI(), res);
		res.addHeader("Content-Type", "application/json");
		String pathInfo = req.getPathInfo();
		//String username = req.getParameter("username");
		if(pathInfo == null) {
			User u = us.getUsersByUsername("iris");
			PrintWriter pw = res.getWriter();
			pw.write(om.writeValueAsString(u));
			pw.close();
		}
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		CorsFix.addCorsHeader(req.getRequestURI(), res);
		res.addHeader("Content-Type", "application/json");
		InputStream reqBody = req.getInputStream();
		
		User u = om.readValue(reqBody, User.class);
		System.out.println(u);
		us.updateUserInfo(u);
		
		
		res.setStatus(200);
	}
	
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		CorsFix.addCorsHeader(req.getRequestURI(),res);
		super.doOptions(req, res);
	}
}
