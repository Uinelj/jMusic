package gui;

import javax.swing.text.MaskFormatter;

public class createMask extends MaskFormatter{

	public createMask(String s){
		
		    try {
		        this.setMask(s);
		    } catch (java.text.ParseException exc) {
		        System.err.println("bad format " + exc.getMessage());
		    }
		 
	}
	
	
	
}
