package org.o7planning.tutorial.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AnnotationExampleServlet
 */


public class AnnotationExampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnnotationExampleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
         
        ServletOutputStream out = response.getOutputStream();
         
        out.println("<html>");
        out.println("<head><title>AnnotationExampleServlet</title></head>");
         
        out.println("<body>");
        out.println("<h3>Hello World AnnotationExampleServlet new 33  222 WORKED 2 !!!=====11 22 33</h3>");        
        out.println("This is my first Servlet AnnotationExampleServlet   aaaaaaa   111111111122222222 !!!=====11 22 333 ");   
        out.println("</body>");
        out.println("<html>");
    }
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
