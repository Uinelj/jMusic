//Dernier changement le 26/02/2015.

package templates;

import java.util.ArrayList;
import java.util.Iterator;

import notes.HarmonicNote;
import notes.Note;
import notes.RythmicNote;


public class TrioletTemplate extends Template{
	
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
                System.out.println("ERROR : L'attribut 1 envoyé à TrioletTemplate n'est pas définit. Cette erreur peut venir"+"\n"+"du fait que la ArrayList envoyée en attribut est vide.");
        }	
	}

}