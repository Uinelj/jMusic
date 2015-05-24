//Dernier changmeent le 26/02/2015

package templates;

import java.util.ArrayList;
import notes.HarmonicNote;
import notes.Note;
import notes.RythmicNote;

/**
 * @author JOHAN
 * TrilleTemplate est un template qui cr�� une suite de rythmicnotes en code dur.
 */
 
public class TrilleTemplate extends Template{
	
	/**
	 * @param templateNotes un template attribue un rythme (length) a des notes donn�es en param�tre  donc il pr�f�re recevoir des arraylist de harmonicnotes
	 */
	public TrilleTemplate(ArrayList<HarmonicNote> templateNotes) {
			
		ArrayList<RythmicNote> trille = new ArrayList<RythmicNote>();
        
        try{
                Note actualNote = templateNotes.get(0);
               
                RythmicNote note1 = new RythmicNote(actualNote.getHeight(), 1);
                RythmicNote note2 = new RythmicNote(note1.getHeight()+1, 1);
                trille.add(note1);
                trille.add(note2);
                trille.add(note1);
               
                super.setTemplate(trille);
        }
        catch(IndexOutOfBoundsException e){
                System.out.println("ERROR : L'attribut 1 envoy� � TrilleTemplate n'est pas d�finit. Cette erreur peut venir"+"\n"+"du fait que la ArrayList envoy�e en attribut est vide.");
        }	
	}

}
