package org.o7planning.tutorial.servlet;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.o7planning.tutorial.servlet.State;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.annotation.*;

public class InitParamServlet extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
 
    private String emailSupport1;
    public ArrayList<Tag> state;
    
    public InitParamServlet() {
    	
    	State stateClass = new State();
    	state = stateClass.getState();
    	
    	 System.out.println("RAVNO="+state.get(0).name);  
    	 
    }
 
     @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
 
        this.emailSupport1 = config.getInitParameter("emailSupport1");
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        String emailSupport2 = this.getServletConfig().getInitParameter("emailSupport2");
 /*
        ServletOutputStream out = response.getOutputStream();
 
        out.println("<html>");
        out.println("<head><title>Init Param</title></head>");
 
        out.println("<body>");
        out.println("<h3>Init Param pam</h3>");
        out.println("<p>emailSupport1 = " + this.emailSupport1 + "</p>");
        out.println("<p>emailSupport2 = " + state[0].name + "</p>");
        out.println("</body>");
        out.println("<html>");
        */
        
        //String objectToReturn = { key1: 'value1', key2: 'value2' };
        System.out.println("doGet="+state.get(0).name);  
        
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
        this.doGet(request, response);
    }
 
}