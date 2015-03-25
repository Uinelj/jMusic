package melody.rythmicMelody;
import java.util.ArrayList;
import java.util.LinkedList;

import rythm.TimeSignature;
import scales.*;
import templates.TrioletTemplate;
import melody.noteGeneration.Melody;
import melody.noteGeneration.MelodyGenerator;
import melody.noteGeneration.Motif;
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
		int time=0;
		float duration=0;//correspond au nombre de temps écoulé
		RythmicNote rythmicNote=new RythmicNote(0, 0);//RythmicNote
	
		//melody.generateMelody(melodySize);;//on génère une mélodie : la mélodie sera mise en constructeur
		while(!melody.getMelody().isEmpty())
		{
			
			int type=(int) Math.floor((Math.random()*2) + 1);//choisi un note rythmic ou un template
			if(type==0)//template
			{
				int templateType=(int) Math.floor((Math.random()*1) + 0);//défini le type de template, ici j'ai mis que le triolet
				if ( templateType ==0)//triolet
				{
					ArrayList<HarmonicNote> templateNotes=new ArrayList<HarmonicNote>();//on créer une ArrayList qui va prendre les notes du template
					if(melody.getMelody().size()>=3)//si la mélodie contient bien trois notes :
					{
						for(int i=0;i<3;i++)
						{
							templateNotes.add(melody.getFirst());//on remplie la ArrayList des 3 premières notes
							melody.getMelody().removeFirst();//on suppriime les trois première notes de la mélodie
						}
						TrioletTemplate template= new TrioletTemplate(templateNotes);//on créer un template
						rythmicMelody.addTemplate(template);//on ajoute le template dans la RythmicMelody
						duration=duration+ts.noteTime(4);//on a 1 noire qui s'est écoulé
					}
					else 
						type=1;
				}
			}
			
			if(type==1)//RythmicNote
			{
				time=(int)( Math.random()*100);

				int prob[]=new int[10];
				prob[0]=0;
				prob[2]=50;//ne pas mettre différent de 0
				prob[3]=0;
				prob[4]=50;
				prob[5]=0;
				prob[6]=0;
				prob[7]=0;
				prob[8]=0;
				prob[9]=0;
				int proba=0;
				for(int i=0;i<10;i++)
				{
					if((time>=proba)&&(time<proba+prob[i])&&(duration<=1-ts.noteTime(i)))
					{
						rythmicNote=new RythmicNote(melody.getMelody().getFirst().getHeight(), i);//on crï¿½er une nouvelle RythmicNote
						duration=duration+ts.noteTime(i);//durée en nombre de temps
						rythmicMelody.addRythmicNote(rythmicNote);//on la rajoute dans la mï¿½lodie
						melody.getMelody().removeFirst();
						System.out.println(i);

					}
					proba=proba+prob[i];

				}
			}
			if(duration==1)
			{
				duration=0;
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
}