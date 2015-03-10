package melody.rythmicMelody;
import java.util.ArrayList;
import java.util.LinkedList;

import scales.*;
import templates.TrioletTemplate;
import melody.noteGeneration.MelodyGenerator;
import notes.HarmonicNote;
import notes.RythmicNote;

public class RythmicMelodyGenerator {
	
	private RythmicMelody rythmicMelody;
	private MelodyGenerator melodyGenerator;
	private Scale scale;
	public RythmicMelodyGenerator(Scale scale, int melodySize)
	{
		rythmicMelody = new RythmicMelody();
		this.scale = scale;
		melodyGenerator = new MelodyGenerator(scale, melodySize);
	}
	
	public void basicMelody()
	{
		int time=0;
		RythmicNote rythmicNote=new RythmicNote(0, 0);
		melodyGenerator.generateMelody(40);
		while(!melodyGenerator.getMelody().getMelody().isEmpty())
		{
			int type=(int) Math.floor((Math.random()*2) + 0);//Note rythmique au pif
			if(type==0)//template
			{
				int templateType=(int) Math.floor((Math.random()*1) + 0);//défini le type de template, ici j'ai mis que le triolet
				if ( templateType ==0)
				{
					ArrayList<HarmonicNote> templateNotes=new ArrayList<HarmonicNote>();
					if(melodyGenerator.getMelody().getMelody().size()>=3)
					{
						for(int i=0;i<3;i++)
						{
							templateNotes.add(melodyGenerator.getFirst());
							melodyGenerator.getMelody().removeFirst();
						}
						TrioletTemplate template= new TrioletTemplate(templateNotes);
						rythmicMelody.addTemplate(template);
					}
					else 
						type=1;
				}
			}
			
			if(type==1)//RythmicNote
			{
				time=(int) Math.floor((Math.random()*101) + 0);//Note rythmique au pif
				if((time<101)&&(time>97))
				{
					rythmicNote=new RythmicNote(melodyGenerator.getMelody().getFirst().getHeight(), 0);//on crï¿½er une nouvelle RythmicNote
				}
				if((time<=97)&&(time>90))
				{
					rythmicNote=new RythmicNote(melodyGenerator.getMelody().getFirst().getHeight(), 1);//on crï¿½er une nouvelle RythmicNote

				}
				if(time<50)
				{
					rythmicNote=new RythmicNote(melodyGenerator.getMelody().getFirst().getHeight(), 3);//on crï¿½er une nouvelle RythmicNote

				}
				if((time>=50)&&(time<=90))
				{
					rythmicNote=new RythmicNote(melodyGenerator.getMelody().getFirst().getHeight(), 4);//on crï¿½er une nouvelle RythmicNote

				}
				rythmicMelody.addRythmicNote(rythmicNote);//on la rajoute dans la mï¿½lodie
				melodyGenerator.getMelody().removeFirst();
				
			}
		}
		
	}
	
	public LinkedList<RythmicNote> GetRythmicMelody()
	{
		return rythmicMelody.getRythmicMelody();
	}
}