package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fasterxml.jackson.databind.ObjectMapper;

import dtos.UserDto;
import models.User;
import services.UserService;
import utils.CorsFix;

public class UserServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserService us = new UserService();
	private ObjectMapper om = new ObjectMapper();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		// Specifying that the response content-type will be JSON
				CorsFix.addCorsHeader(req.getRequestURI(), res);
				res.addHeader("Content-Type", "application/json");


				/*-
				 * Extra path information associated with the URL the client sent when it made this request
				 * 	- ie: 
				 * 		- "/1" if /users/1
				 * 		- null if /users
				 */
				String pathInfo = req.getPathInfo();

				// if pathInfo is null, the req should be to /users -> send back all users
				if (pathInfo == null) {

					/*-
					 *  HttpSession allows us to retrieve information placed in the session object passed in a previous HttpResponse 
					 *  	- in this case, the Session is set in the AuthServlet
					 */

					
						// retrieving users from db using UserService
						List<User> users = us.getUsers();
						List<UserDto> usersDTO = new ArrayList<>();

						// converting Users to UserDTOs for data transfer
						users.forEach(u -> usersDTO.add(new UserDto(u)));

						// retrieving print writer to write to the Response body
						PrintWriter pw = res.getWriter();
						// writing toString representation of Users to body
						pw.write(om.writeValueAsString(usersDTO));

						pw.close();
					
				} 
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
	}
	
}
