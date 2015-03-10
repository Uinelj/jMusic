package melody.tools;
import java.util.ArrayList;

import scales.*;
import notes.HarmonicNote;


public class PianoNotes {
	private ArrayList<HarmonicNote> piano;
	private Scale scale;
	public PianoNotes(Scale scale)
	{
		piano = new ArrayList<HarmonicNote>();
		this.scale=scale;
		initPiano();
	}
	
	private void initPiano()
	{
		int fundamental=scale.getFundamental().getHeight();//on prend la fondamentale
		while(fundamental>11)
		{
			fundamental=fundamental-12;//on descend la gamme jusqu'a obtenir la note la plus basse correspondant à la fondamental
		}			
		while(fundamental<120)//on remonte jusqu'a obtenir toutes les notes jouable sur la gamme 
		{
			
			for(int i=0;i<scale.getNotes().size();i++)
			{
				piano.add(scale.getNotes().get(i));
			}
			fundamental=fundamental+12;
			
		}
	}
	
	public ArrayList<HarmonicNote> getpiano()
	{
		return piano;
	}
	
	public HarmonicNote getPiano(int index)
	{
		return piano.get(index);
	}
	public void setScale(Scale scale)
	{
		this.scale=scale;
		piano.clear();
		initPiano();
	}
	
}
