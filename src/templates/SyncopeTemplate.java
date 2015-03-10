//Dernier changement le 27/02/2015

package templates;

import java.util.ArrayList;
import java.util.Iterator;

import notes.HarmonicNote;
import notes.RythmicNote;

public class SyncopeTemplate extends Template{
	
	public SyncopeTemplate(ArrayList<HarmonicNote> templateNotes){
		
			ArrayList<RythmicNote> syncope = new ArrayList<RythmicNote>();
		try{	
			Iterator<HarmonicNote> iter = templateNotes.iterator();
			HarmonicNote actualNote;
			int i = 3; //variable qui d�cidera successivement de la lenght de la rythmicNote cr�e.
			
			while(iter.hasNext()){
				actualNote = iter.next();
				RythmicNote note = new RythmicNote(actualNote.getHeight(), i);//successivement croche, puis noire
				syncope.add(note);
				if(i==3){
					i++;
				}
				else if(i==4){
					i=3;
				}
			}
			
			super.setTemplate(syncope);
			
		}	
		 catch(IndexOutOfBoundsException e){
                System.out.println("ERROR : L'attribut 1 envoy� � SyncopeTemplate n'est pas d�finit. Cette erreur peut venir"+"\n"+"du fait que la ArrayList envoy�e en attribut est vide.");
        }	
	}

}