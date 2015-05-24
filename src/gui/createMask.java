package gui;

import javax.swing.text.MaskFormatter;

/**
 * creqte mask est utilisé une ou deux fois pour instancier un masque de JTextField selon une string de masque
 *
 * @author JOHAN
 *
 */
public class createMask extends MaskFormatter{

	/**
	 * @param s masque de texte (String) a attribuer au maskFormater. Testé si valide dans le constructeur.
	 */
	public createMask(String s){
		
		    try {
		        this.setMask(s);
		    } catch (java.text.ParseException exc) {
		        System.err.println("bad format " + exc.getMessage());
		    }
		 
	}
	
	
	
}
