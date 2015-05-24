package melody.rythmicMelody;
import java.util.ArrayList;
import java.util.LinkedList;

import rythm.TimeSignature;
import scales.*;
import templates.TrioletTemplate;
import melody.noteGeneration.Melody;
import melody.noteGeneration.MelodyGenerator;
import melody.noteGeneration.Motif;
import melody.tools.ProbabilityTable;
import notes.HarmonicNote;
import notes.RythmicNote;

public class RythmedMelody {
	
	private RythmicMelody rythmicMelody;
	private Scale scale;
	private TimeSignature ts ;
	private Melody melody;
	private int melodySize;
	public RythmedMelody(Melody melody, Scale scale, int melodySize, TimeSignature ts)
	{
		rythmicMelody = new RythmicMelody();
		this.scale = scale;
		this.melody=melody;
		this.ts=ts;
		this.melodySize=melodySize;
	}
	
	public void generateRythmicMelody()
	{
		float duration=0;//correspond au nombre de temps écoulé
		RythmGraph g = new RythmGraph();
		RythmicNote rythmicNote=new RythmicNote(0, 0);//RythmicNote
		int proba=0;
		int actu=0;
		int time=0;
		int actu1=0;
		int dc=0;
		int tc=0;
		while(!melody.getMelody().isEmpty())
		{
			
				time=(int)( Math.random()*100);
				proba=0;
				
				for(int i=0;i<10;i++)
				{
					if((time>=proba)&&(time<proba+g.getProba(actu,i)))
					{
						duration=duration+ts.noteTime(i);
						rythmicNote=new RythmicNote(melody.getMelody().getFirst().getHeight(), i);//on crï¿½er une nouvelle RythmicNote
						rythmicMelody.addRythmicNote(rythmicNote);//on la rajoute dans la mï¿½lodie
						melody.getMelody().removeFirst();
						//System.out.println(ts.noteTime(i));
						//System.out.println(duration);
						actu1=i;
						
					}
					proba=proba+g.getProba(actu,i);
					actu=actu1;
				}
				
				if((actu==0)&&(!melody.getMelody().isEmpty()))
				{
					for(int note=0;note<4;note++)
					rythmicNote=new RythmicNote(melody.getMelody().getFirst().getHeight(), 0);//on crï¿½er une nouvelle RythmicNote
					rythmicMelody.addRythmicNote(rythmicNote);//on la rajoute dans la mï¿½lodie
					melody.getMelody().removeFirst();
				}
				if((actu==1)&&(!melody.getMelody().isEmpty()))
				{
					rythmicNote=new RythmicNote(melody.getMelody().getFirst().getHeight(), 0);//on crï¿½er une nouvelle RythmicNote
					rythmicMelody.addRythmicNote(rythmicNote);//on la rajoute dans la mï¿½lodie
					melody.getMelody().removeFirst();
				}
				
				
		}
	}
		
	
	public void setMelody(Melody newMelody)//change la valeur des notes des RythmicNotes de la fifo
	{
		for(int i=0;i<newMelody.getMelody().size();i++)
		{
			melody.getMelody().get(i).setHeight(newMelody.getMelody().get(i).getHeight());
		}
	}
	
	public LinkedList<RythmicNote> GetRythmicMelody()
	{
		return rythmicMelody.getRythmicMelody();
	}
	
	public RythmicMelody GetRythmicMelodyObject(){
	
		return rythmicMelody;
	}
}