package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// set response message mime type
		response.setContentType("text/html; charset=UTF-8");
		
		// allocate a output writer to write the response message into 
		// the network socket
		PrintWriter out = response.getWriter();
		
		// write the response message in HTML
		try {
			out.print("<!DOCTYPE html>");
			out.print("<html>");
			out.print("<head>");
			out.print("<meta http-equiv='Content-Type' content='text/html; charset='UTF-8'>");
			out.print("<title>Helloe World!</title>");
			out.print("</head>");
			out.print("<body>");
			out.print("<h1>Hello World!</h1>");
			// echo client's request information
			out.print("<p>Request URI: "+ request.getRequestURI() + "</p>");
			out.print("<p>Protocol: "+ request.getProtocol() + "</p>");
			out.print("<p>Path Info: "+ request.getPathInfo() + "</p>");
			out.print("<p>Remote Address: "+ request.getRemoteAddr() + "</p>");
			// generate a random number upon each request
			out.print("<p>Random Number: <strong>"+ Math.random() + "</strong></p>");
			out.print("</body>");
			out.print("</html>");
		} finally {
			// alsways close the output writer
			out.close();
		}
	}

}
