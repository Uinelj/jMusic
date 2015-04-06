package melody.noteGeneration;

import java.util.ArrayList;

import melody.tools.Counter;
import melody.tools.Piano;
import melody.tools.PianoNotes;
import melody.tools.ProbabilityTable;
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
		Integer position=index;
		Motif motif = new Motif(melody, scale);
		for(int i=0;i<50;i++)
		{
			int nbIncre=(int)( Math.random()*5);
			int moreless=(int)( Math.random()*6);
			
			if(moreless==0)
				position=motif.conGammeRight(position,nbIncre);
			
			if(moreless==1)
				position=motif.conGammeLeft(position, nbIncre);

			if(moreless==2)
				position=motif.motifalea(position, nbIncre);
			
			if(moreless==3)
				position=motif.centred(position, nbIncre);
			
			if(moreless==4)
				position=motif.tierceLeft(position, nbIncre);
			
			if(moreless==5)
				position=motif.tierceRight(position, nbIncre);
			
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
