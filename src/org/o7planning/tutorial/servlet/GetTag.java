package org.o7planning.tutorial.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import javax.servlet.ServletConfig;

import org.o7planning.tutorial.servlet.State;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
 

/**
 * Servlet implementation class GetTag
 */
@WebServlet("/rest/tag")


public class GetTag extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
 
    public ArrayList<Tag> state;
    State stateClass = new State();
    ErrorGenerator errorObj;
    
    public GetTag() {
    	state = stateClass.getState();
    }
 
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
         ServletOutputStream out = response.getOutputStream(); 
        ObjectMapper objectMapper= new ObjectMapper();  
        objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY); 
        String jsonString = objectMapper.writeValueAsString(state);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(jsonString); 
        out.flush();
         
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
   	 	String name = request.getParameter("name");
   	 	String mnemonics = request.getParameter("mnemonics");
   	 	
   	 	if (name==null||mnemonics==null) {
   	 		errorObj = new ErrorGenerator("2", "specify all fields for post (name, mnemonics)");
   	 		this.sendError(request, response);
   	 	} else {
	   	 	stateClass.pushElement(name, mnemonics);
	   	 	state = stateClass.getState();
	   	    this.doGet(request, response);
   	 	}
   	 	
    }
    
    protected void sendError(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    	ServletOutputStream out = response.getOutputStream(); 
        ObjectMapper objectMapper= new ObjectMapper();  
        objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY); 
        String jsonString = objectMapper.writeValueAsString(errorObj);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(jsonString); 
        out.flush();
        
    }
    
    @Override
 	protected void doPut(HttpServletRequest req, HttpServletResponse resp) 
 	            throws ServletException, java.io.IOException {
 		errorObj = new ErrorGenerator("0", "this request at this address is not processed");
  		this.sendError(req, resp);
 	}
    @Override
   	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) 
   	            throws ServletException, java.io.IOException {
   		errorObj = new ErrorGenerator("0", "this request at this address is not processed");
    		this.sendError(req, resp);
   	}
    
}
