package org.o7planning.tutorial.servlet;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.o7planning.tutorial.servlet.ErrorGenerator;


@WebServlet(urlPatterns = { "/*" }) 

public class MyDefaultServlet extends HttpServlet {
 
  
   public MyDefaultServlet() {
   }
 
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
 
	   	
    
       ServletOutputStream out = response.getOutputStream(); 
       ObjectMapper objectMapper= new ObjectMapper();  
       objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY); 
       
       ErrorGenerator errorObj = new ErrorGenerator("1", "This request is not processed");
       
       String jsonString = objectMapper.writeValueAsString(errorObj);
       
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