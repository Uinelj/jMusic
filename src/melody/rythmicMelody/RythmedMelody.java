package melody.rythmicMelody;
import java.util.ArrayList;
import java.util.LinkedList;
import rythm.TimeSignature;
import scales.*;
import templates.TrioletTemplate;
import melody.noteGeneration.MelodyJazz;
import notes.HarmonicNote;
import notes.RythmicNote;

public class RythmedMelody {
	
	private RythmicMelody rythmicMelody;
	private MelodyJazz melodyGenerator;
	private Scale scale;
	private TimeSignature ts ;
	
	public RythmedMelody(Scale scale, int melodySize, TimeSignature ts)
	{
		rythmicMelody = new RythmicMelody();
		this.scale = scale;
		melodyGenerator = new MelodyJazz(scale, melodySize);
		this.ts=ts;
	}
	
	public void generateRythmicMelody()
	{
		int time=0;
		float duration=0;
		RythmicNote rythmicNote=new RythmicNote(0, 0);
		melodyGenerator.generateMelody(40);
		while(!melodyGenerator.getMelody().getMelody().isEmpty())
		{
			int type=(int) Math.floor((Math.random()*2) + 1);//choisi un note rythmic ou un template
			if(type==0)//template
			{
				int templateType=(int) Math.floor((Math.random()*1) + 0);//défini le type de template, ici j'ai mis que le triolet
				if ( templateType ==0)//triolet
				{
					ArrayList<HarmonicNote> templateNotes=new ArrayList<HarmonicNote>();//on créer une ArrayList qui va prendre les notes du template
					if(melodyGenerator.getMelody().getMelody().size()>=3)//si la mélodie contient bien trois notes :
					{
						for(int i=0;i<3;i++)
						{
							templateNotes.add(melodyGenerator.getFirst());//on remplie la ArrayList des 3 premières notes
							melodyGenerator.getMelody().removeFirst();//on suppriime les trois première notes de la mélodie
						}
						TrioletTemplate template= new TrioletTemplate(templateNotes);//on créer un template
						rythmicMelody.addTemplate(template);//on ajoute le template dans la RythmicMelody
						duration=duration+ts.noteTime(4);//on a 1 temps qui c'est écoulé
					}
					else 
						type=1;
				}
			}
			
			if(type==1)//RythmicNote
			{
				time=(int) Math.floor((Math.random()*101) + 0);//Note rythmique au pif
				if((time<101)&&(time>80)&&(duration<=1-ts.noteTime(0)))
				{
					rythmicNote=new RythmicNote(melodyGenerator.getMelody().getFirst().getHeight(), 0);//on crï¿½er une nouvelle RythmicNote
					duration=duration+ts.noteTime(0);//durée en nombre de temps
				}
				if((time<=80)&&(time>50)&(duration<=1-ts.noteTime(1)))
				{
						rythmicNote=new RythmicNote(melodyGenerator.getMelody().getFirst().getHeight(), 1);//on crï¿½er une nouvelle RythmicNote
						duration=duration+ts.noteTime(1);//durée en nombre de temps
				}
				if((time<30)&&(duration<=1-ts.noteTime(3)))
				{
						rythmicNote=new RythmicNote(melodyGenerator.getMelody().getFirst().getHeight(), 3);//on crï¿½er une nouvelle RythmicNote
						duration=duration+ts.noteTime(3);//durée en nombre de temps
				}
				if((time>=30)&&(time<=50)&&(duration<=1-ts.noteTime(4)))
				{
					rythmicNote=new RythmicNote(melodyGenerator.getMelody().getFirst().getHeight(), 4);//on crï¿½er une nouvelle RythmicNote
					duration=duration+ts.noteTime(4);//durée en nombre de temps
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