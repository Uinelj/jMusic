package melody.noteGeneration;

import melody.tools.PianoNotes;
import melody.tools.Repetition;
import notes.HarmonicNote;
import scales.Scale;

public class MelodyGenerator {

	private Melody melody;
	private Scale scale;
	private PianoNotes piano;
	private int melodySize;
	public MelodyGenerator(Scale scale, int melodySize)
	{
		this.scale=scale;
		melody = new Melody();
		piano = new PianoNotes(scale);
		this.melodySize=melodySize;
	}
	
	
	
	public Melody generateMelody(Integer index) //on g�n�re un bloc de note qui va potentielement pouvoir se r�p�ter
	{
		for(int i=0;i<melodySize;i++)// on remplie notre th�me
		{	
			index=nextNote(index);//on g�n�re la note suivante
			melody.add(piano.getPiano(nextNote(index)));//on l'ajoute dans la fifo
		}

		return melody;
	}
	
	
	private Integer nextNote(Integer position)//donne la position de la prochaine note � g�n�rer
	{
		int moreless=(int) Math.floor((Math.random() * 2) + 0);//on prend un chiffre al�atoire entre 0 et 1 pour savoir si on prend une note inferieur ou superieur
		int nbIncre=(int) Math.floor((Math.random() * 100) + 0);//on prend un chiffre al�atoire de 0 � 100
		if(nbIncre<=50)
			nbIncre=1;// ton : 50% de chance d'apparaitre
		else if((nbIncre>50)&&(nbIncre<80))
			nbIncre=2;//tierce : 30% 
		else if((nbIncre>=80)&&(nbIncre<88))
			nbIncre=3;//quarte : 8% 
		else if((nbIncre>=88)&&(nbIncre<95))
			nbIncre=4;//quinte : 7%
		else if((nbIncre>=95)&&(nbIncre<100))
			nbIncre=0;//unisson : 5%

		if((moreless==0)&&(position<50))//a partir de la 50e note, on ne peut que d�cr�menter
		{
				position=position+nbIncre;
		}
		if((moreless==1)&&(position>=10))//avant la 20e note, on ne peux que incr�menter pour �viter d'avoir des sons trop grave
		{
				position=position-nbIncre;	
		}
		
		return position;
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
