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

public class Rythmic {
	
	private RythmicMelody rythmicMelody;
	private Scale scale;
	private TimeSignature ts ;
	public Rythmic(Melody melody, Scale scale, TimeSignature ts)
	{
		rythmicMelody = new RythmicMelody();
		this.scale = scale;
		this.ts=ts;
	}
	
	public RythmicNote generateRythmicMelody(HarmonicNote note)
	{
		float duration=0;//correspond au nombre de temps écoulé
		RythmGraph g = new RythmGraph();
		RythmicNote rythmicNote=new RythmicNote(0, 0);//RythmicNote
		int proba=0;
		int actu=0;
		int time=0;
		int actu1=0;
	
				time=(int)( Math.random()*100);
				proba=0;
				
				for(int i=0;i<10;i++)
				{
					if((time>=proba)&&(time<proba+g.getProba(actu,i)))
					{
						rythmicNote=new RythmicNote(note.getHeight(), i);//on crï¿½er une nouvelle RythmicNote
						System.out.println(duration);
						actu1=i;
					}
					proba=proba+g.getProba(actu,i);
					actu=actu1;
				}
				
				return rythmicNote;
		}
		
	

	public LinkedList<RythmicNote> GetRythmicMelody()
	{
		return rythmicMelody.getRythmicMelody();
	}
}