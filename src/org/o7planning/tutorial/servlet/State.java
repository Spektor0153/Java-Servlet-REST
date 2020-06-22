package org.o7planning.tutorial.servlet;

import java.util.ArrayList;

public class State {
	   
	   static ArrayList<Tag> tagArray = StateInit.getState();
	   
	   State() { 
	}
	  
	   
	    public static ArrayList<Tag> getState() {
	    	return tagArray; 
	    }
	    public static Tag getTag(String name) {
	    	 for (int i = 0; i<tagArray.size(); i++){
			      if (tagArray.get(i).name.equals(name)) {
			    	  return tagArray.get(i);
			      } 
			 }
			return null;
	    }
	    
	    public static ArrayList<Tag> searchTags(String mnemonics) {
	    	 
	    	ArrayList<Tag> tagArraysearch = new ArrayList<Tag>();
	    	
	    	for (int i = 0; i<tagArray.size(); i++){
			      if (tagArray.get(i).mnemonics.indexOf(mnemonics)!=-1) {
			    	  tagArraysearch.add(tagArray.get(i));
			      } 
			 }
	    	return tagArraysearch; 
	    }
	    
	    public void pushElement(String name, String mnemonics) {
	    	 tagArray.add( new Tag(name, mnemonics));
	    }
	    
	    public void deleteElement(String name) {
	    	 for (int i = 0; i<tagArray.size(); i++){
			      if (tagArray.get(i).name.equals(name)) {
			    	  tagArray.remove(i);
			      } 
			 }
	    	
	    }
	    
	    public void updateElement(String oldName, String name, String mnemonics) {
	    	 for (int i = 0; i<tagArray.size(); i++){
			      if (tagArray.get(i).name.equals(oldName)) {
			    	  tagArray.set(i,  new Tag(name, mnemonics));
			      } 
			 }
	    	
	    }
	    
	   
}
 
class StateInit {
	 static ArrayList<Tag> tagArray = new ArrayList<Tag>();

	StateInit() { 
	  
    }
	public static ArrayList<Tag> getState() {
		  tagArray.add( new Tag("Tom", "mnemonics1"));
		  tagArray.add( new Tag("Tom2", "mnemonics2"));
		  tagArray.add( new Tag("Tom3", "mnemonics3"));
   	return tagArray; 
   }
	
  
}
 
class Tag {
	String name, mnemonics;
	   
	public Tag (String name, String mnemonics){
	   this.name = name;
	   this.mnemonics = mnemonics;
	}
}