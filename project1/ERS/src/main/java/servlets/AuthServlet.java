package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import dtos.UserDto;
import exceptions.UserNotFoundException;
import models.User;
import services.AuthService;
import utils.CorsFix;


public class AuthServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AuthService as = new AuthService();
	private ObjectMapper om = new ObjectMapper();
	private static Logger log = LogManager.getLogger(AuthServlet.class);
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		CorsFix.addCorsHeader(req.getRequestURI(), res);
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		try {
			User principal = as.login(username, password);
			
			HttpSession session = req.getSession();
			session.setAttribute("userId", principal.getId());
			session.setAttribute("userRole", principal.getRoleId());
			
			// To make Chrome work with our cookie
			String cookie = res.getHeader("Set-Cookie") + "; SameSite=None; Secure";
			res.setHeader("Set-Cookie", cookie);;
			
			UserDto principalDTO = new UserDto(principal);
			try(PrintWriter pw = res.getWriter()){
				pw.write(om.writeValueAsString(principalDTO));
				res.setStatus(200);
			}
			log.info("Login successfully");

		} catch (UserNotFoundException | LoginException e) {
			log.error("Login exception was thrown: " + e.fillInStackTrace());
			res.sendError(400, "Login unsuccessful.");
			e.printStackTrace();
		} 
	}
	
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		CorsFix.addCorsHeader(req.getRequestURI(), res);
		
		HttpSession session = req.getSession();
		
		session.invalidate();
	}
	
	
	// used to prevent CORS preflight issue
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		CorsFix.addCorsHeader(req.getRequestURI(),res);
		super.doOptions(req, res);
	}
}