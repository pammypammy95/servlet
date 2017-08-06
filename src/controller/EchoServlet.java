package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EchoServlet
 */
@WebServlet("/EchoServlet")
public class EchoServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// set the response message's mime type
		response.setContentType("text/html; charset=UTF-8");
		// allocate a output writer to write the response message into 
		// the network socket
		PrintWriter out = response.getWriter();
		
		// write the response message, in HTML
		try {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
			out.println("<title>Echo Servlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h2>You have enter </h2>");
			
			String username = request.getParameter("username");
			
			if(username == null || (username = htmlFilter(username.trim())).length() == 0){
				out.println("<p>Name: Missing </p>");
			}else{
				out.println("<p>Name: " + username + "</p>");
			}
			
			String password = request.getParameter("password");
			
			if(password == null || (password = htmlFilter(password.trim())).length() == 0){
				out.println("<p>Password: Missing </p>");
			}else{
				out.println("<p>Password: " + password + "</p>");
			}
			
			String gender = request.getParameter("gender");
			
			if(gender == null){
				out.println("<p>Gender: Missing </p>");
			}else if(gender.equals("m")){
				out.println("<p>Gender: Male </p>");
			}else{
				out.println("<p>Gender: Female</p>");
			}
			
		} finally {
			// TODO: handle finally clause
		}
		
	}

}
