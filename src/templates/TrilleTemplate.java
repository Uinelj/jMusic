//Dernier changmeent le 26/02/2015

package templates;

import java.util.ArrayList;
import notes.HarmonicNote;
import notes.Note;
import notes.RythmicNote;

public class TrilleTemplate extends Template{
	/*
	 * Makes a Trill
	 * */
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
                System.out.println("ERROR : L'attribut 1 envoyé à TrilleTemplate n'est pas définit. Cette erreur peut venir"+"\n"+"du fait que la ArrayList envoyée en attribut est vide.");
        }	
	}

}
