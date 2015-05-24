//Dernier changement le 26/02/2015.

package templates;

import java.util.ArrayList;
import java.util.Iterator;

import notes.HarmonicNote;
import notes.Note;
import notes.RythmicNote;


/**
 * @author JOHAN
 * TriolletTemplate est un template qui cr�� une suite de rythmicnotes en code dur.
 */
public class TrioletTemplate extends Template{
	
	/**
	 * @param templateNotes un template attribue un rythme (length) a des notes donn�es en param�tre donc il pr�f�re recevoir des arraylist de harmonicnotes
	 */
	public TrioletTemplate(ArrayList<HarmonicNote> templateNotes) {
			
			ArrayList<RythmicNote> triolet = new ArrayList<RythmicNote>();
		try{
			Iterator<HarmonicNote> iter = templateNotes.iterator();
			Note actualNote;
			
			while(iter.hasNext()){
				actualNote = iter.next();
				RythmicNote note = new RythmicNote(actualNote.getHeight(), 2);
				triolet.add(note);
			}
				
			super.setTemplate(triolet);	
		}
		catch(IndexOutOfBoundsException e){
                System.out.println("ERROR : L'attribut 1 envoy� � TrioletTemplate n'est pas d�finit. Cette erreur peut venir"+"\n"+"du fait que la ArrayList envoy�e en attribut est vide.");
        }	
	}

}