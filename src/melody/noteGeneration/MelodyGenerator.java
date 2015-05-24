package melody.noteGeneration;

import java.util.ArrayList;

import melody.tools.Counter;
import melody.tools.Piano;
import melody.tools.PianoNotes;
import melody.tools.ProbabilityTable;
import notes.HarmonicNote;
import notes.RythmicNote;
import scales.Scale;

public class MelodyGenerator {

	private Melody melody;
	private Piano piano;
	private int melodySize;
	
	public MelodyGenerator(Scale scale, int melodySize) 
	{
		melody = new Melody();
		piano = new Piano(scale);
		piano.toString();
		this.melodySize=melodySize;
	}
	
	
	
	public Melody generateMelody(Integer index) 
	{
		int time=0;
		int proba=0;
		int degre=piano.getdegre(index);
		int exit = 0;
		Integer note=index;
		
		NoteGraph g = new NoteGraph();
		for(int i=0;i<melodySize;i++)
		{
			
				proba=0;
				time=(int)( Math.random()*100);
				exit = 0;
				
					if((time>proba)&&(time<proba+g.getProba(degre, 0))&&(exit==0))
					{
						exit=1;
						melody.add(piano.getPiano(note));
					}
					
					proba=proba+g.getProba(degre, 0);
					
					if((time>proba)&&(time<proba+g.getProba(degre, 1))&&(exit==0))
					{
						if(piano.getPiano(note).getHeight()<80)
						{
							note=note+1;
							melody.add(piano.getPiano(note));
							degre=piano.incrementDegre(degre, 1);
							exit=1;

						}
					}					
					proba=proba+g.getProba(degre, 1);
					
					if((time>proba)&&(time<proba+g.getProba(degre, 2))&&(exit==0))
					{
						if(piano.getPiano(note).getHeight()<89)
						{
							note=note+2;
							melody.add(piano.getPiano(note));
							degre=piano.incrementDegre(degre, 2);
							exit=1;

						}
					}					
					proba=proba+g.getProba(degre, 2);
					
					if((time>proba)&&(time<proba+g.getProba(degre, 3))&&(exit==0))
					{
						if(piano.getPiano(note).getHeight()<88)
						{
							note=note+3;
							melody.add(piano.getPiano(note));
							degre=piano.incrementDegre(degre, 3);
							exit=1;

						}
					}					
					proba=proba+g.getProba(degre, 3);
					
					if((time>proba)&&(time<proba+g.getProba(degre, 4))&&(exit==0))
					{
						if(piano.getPiano(note).getHeight()<87)
						{
							note=note+4;
							melody.add(piano.getPiano(note));
							degre=piano.incrementDegre(degre, 4);
							exit=1;

						}
					}					
					proba=proba+g.getProba(degre, 4);
					
					if((time>proba)&&(time<proba+g.getProba(degre, 5))&&(exit==0))
					{
						if(piano.getPiano(note).getHeight()<86)
						{
							note=note+5;
							melody.add(piano.getPiano(note));
							degre=piano.incrementDegre(degre, 5);
							exit=1;

						}
					}					
					proba=proba+g.getProba(degre, 5);
					
					if((time>proba)&&(time<proba+g.getProba(degre, 6))&&(exit==0))
					{
						if(piano.getPiano(note).getHeight()<85)
						{
							note=note+6;
							melody.add(piano.getPiano(note));
							degre=piano.incrementDegre(degre, 6);
							exit=1;

						}
					}					
					proba=proba+g.getProba(degre, 6);
					
					if((time>proba)&&(time<proba+g.getProba(degre, 7)))
					{
						if(piano.getPiano(note).getHeight()<84)
						{
							note=note+7;
							melody.add(piano.getPiano(note));
							degre=piano.incrementDegre(degre, 7);
							exit=1;

						}
					}					
					proba=proba+g.getProba(degre, 7);
					
					if((time>proba)&&(time<proba+g.getProba(degre, 8)))
					{
						if(piano.getPiano(note).getHeight()>50)
						{
							note=note-1;
							melody.add(piano.getPiano(note));
							degre=piano.DecrementDegre(degre, 1);
							exit=1;

						}
					}					
					proba=proba+g.getProba(degre, 8);
					
					if((time>proba)&&(time<proba+g.getProba(degre, 9)))
					{
						if(piano.getPiano(note).getHeight()>51)
						{
							note=note-2;
							melody.add(piano.getPiano(note));
							degre=piano.DecrementDegre(degre, 2);
							exit=1;

						}
					}					
					proba=proba+g.getProba(degre, 9);
					
					if((time>proba)&&(time<proba+g.getProba(degre, 10))&&(exit==0))
					{
						if(piano.getPiano(note).getHeight()>52)
						{
							note=note-3;
							melody.add(piano.getPiano(note));
							degre=piano.DecrementDegre(degre, 3);
							exit=1;
						}
					}					
					proba=proba+g.getProba(degre, 10);
					
					if((time>proba)&&(time<proba+g.getProba(degre, 11))&&(exit==0))
					{
						if(piano.getPiano(note).getHeight()>53)
						{
							note=note-4;
							melody.add(piano.getPiano(note));
							degre=piano.DecrementDegre(degre, 4);
							exit=1;

						}
					}					
					proba=proba+g.getProba(degre, 11);
					
					if((time>proba)&&(time<proba+g.getProba(degre, 12))&&(exit==0))
					{
						if(piano.getPiano(note).getHeight()>54)
						{
							note=note-5;
							melody.add(piano.getPiano(note));
							degre=piano.DecrementDegre(degre, 5);
							exit=1;

						}
					}					
					proba=proba+g.getProba(degre, 12);
					
					if((time>proba)&&(time<proba+g.getProba(degre, 13))&&(exit==0))
					{
						if(piano.getPiano(note).getHeight()>55)
						{
							note=note-6;
							melody.add(piano.getPiano(note));
							degre=piano.DecrementDegre(degre, 6);
							exit=1;

						}
					}					
					proba=proba+g.getProba(degre, 13);
					
					if((time>proba)&&(time<proba+g.getProba(degre, 14))&&(exit==0))
					{
						if(piano.getPiano(note).getHeight()>56)
						{
							note=note-7;
							melody.add(piano.getPiano(note));
							degre=piano.DecrementDegre(degre, 7);
							exit=1;

						}
					}		
					System.out.println(piano.getPiano(note));
				}
		
		return melody;
	}
	
	
	
	
	public Melody getMelody()
	{
		return melody;
	}
	
	public HarmonicNote getFirst()
	{
		return melody.getFirst();
	}
	
}
