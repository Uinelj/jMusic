package melody.noteGeneration;

import melody.tools.Counter;
import melody.tools.Piano;
import melody.tools.PianoNotes;
import notes.HarmonicNote;
import scales.Scale;

public class MelodyGenerator {

	private Melody melody;
	private Scale scale;
	private Piano piano;
	private int melodySize;
	public MelodyGenerator(Scale scale, int melodySize) 
	{
		this.scale=scale;
		melody = new Melody();
		piano = new Piano(scale);
		piano.toString();
		this.melodySize=melodySize;
	}
	
	
	
	public Melody generateMelody(Integer index) //on génère un bloc de note qui va potentielement pouvoir se répéter
	{
		/*for(int i=0;i<melodySize;i++)// on remplie notre thème
		{	
			index=rules(index);//on génère la note suivante
			melody.add(piano.getPiano(rules(index)));//on l'ajoute dans la fifo
			System.out.println(index);
		}
		*/
		Integer position=index;
		Motif motif = new Motif(melody, scale);
		for(int i=0;i<50;i++)
		{
			int nbIncre=(int)( Math.random()*5);
			int moreless=(int)( Math.random()*4);
			if(moreless==0)
				position=motif.conGammeRight(position,nbIncre);
			
			if(moreless==1)
				position=motif.conGammeLeft(position, nbIncre);

			if(moreless==2)
				position=motif.motifalea(position, nbIncre);
			
			if(moreless==3)
				position=motif.centred(position, nbIncre);
			
			
		}
		System.out.println(piano.toString());
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
