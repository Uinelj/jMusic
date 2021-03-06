package melody.tools;
import java.util.ArrayList;

import scales.*;
import notes.HarmonicNote;

/**
 * classe de traitement : g�n�re les notes jouables sur la gamme du piano
 *
 * @author AKTOR Alexis
 *
 */
public class Piano {
	private ArrayList<PianoNotes> piano;
	private Scale scale;
	
	public Piano(Scale scale)
	{
		piano = new ArrayList<PianoNotes>();
		this.scale=scale;
		initPiano();
	}
	
	private void initPiano()
	{
		int fundamental=scale.getFundamental().getHeight();//on prend la fondamentale
		int degres=1;
		PianoNotes notes = new PianoNotes(new HarmonicNote(0), 0);
		while(fundamental>11)
		{
			fundamental=fundamental-12;//on descend la gamme jusqu'a obtenir la note la plus basse correspondant � la fondamental
		}			
		while(fundamental<120)//on remonte jusqu'a obtenir toutes les notes jouable sur la gamme 
		{
			scale = new Scale(new HarmonicNote(fundamental), scale.getMode());
			for(int i=0;i<scale.getNotes().size();i++)
			{
				notes = new PianoNotes(scale.getNotes().get(i),degres);
				piano.add(notes);
				degres++;
			}
			degres=1;
			fundamental=fundamental+12;
			
		}
	}
	
	

	
	public String toString() {
		String str = "";
		for(int i=0;i<piano.size();i++)
		{
			str = str +"note"+ piano.get(i).getNote() + " degre : " + piano.get(i).getDegre();
		}
		return str;
	}

	public ArrayList<PianoNotes> getpiano()
	{
		return piano;
	}
	
	public HarmonicNote getPiano(int index)
	{
		return piano.get(index).getNote();
	}
		
	public int getdegre(int index)
	{
		return piano.get(index).getDegre();
	}
		
	public int incrementDegre(int deg, int inc)
	{
		int nbrdegre = scale.getNotes().size();
		deg=deg+inc;
		
		while(deg>nbrdegre)
		{
			deg=deg-nbrdegre;
		}
		
		return deg;
		
	}
	
	public int DecrementDegre(int deg, int inc)
	{
		int nbrdegre = scale.getNotes().size();
		deg=deg-inc;
		
		while(deg<=0)
		{
			deg=deg+nbrdegre;
		}
		
		return deg;
		
	}
	
	public void setScale(Scale scale)
	{
		this.scale=scale;
		piano.clear();
		initPiano();
	}
	
}