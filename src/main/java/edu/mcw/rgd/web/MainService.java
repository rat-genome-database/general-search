package edu.mcw.rgd.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloServlet", urlPatterns = {"/hello","/main.html","/RgdSearch.jsp","/advSearch.jsp"}, loadOnStartup = 1) 
public class MainService extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        justDo(request, response);  
    }
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        justDo(request, response); 
    }	

    protected void justDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        if (name == null) name = "World";
        request.setAttribute("user", name);

        String id = request.getParameter("id");
		if( id==null ) {
			id = request.getParameter("searchKeyword");
			if( id==null ) {
				id = "";
			}
		}

		boolean test = false;
		if( test) {
			request.setAttribute("id", id);

			request.setAttribute("uri", request.getRequestURI());
			request.setAttribute("info", request.getLocalName());

			request.getRequestDispatcher("response.jsp").forward(request, response); 
		} else {
			response.sendRedirect("https://"+request.getLocalName()+"/rgdweb/elasticResults.html?category=General&term="+id);
		}
    }	
}
