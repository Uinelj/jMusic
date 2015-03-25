package melody.noteGeneration;

import melody.tools.Counter;
import melody.tools.Piano;
import melody.tools.PianoNotes;
import scales.Scale;

public class Motif 
{
	private Melody melody;
	private Scale scale;
	private Piano piano;
	public Motif(Melody melody, Scale scale)
	{
		this.melody=melody;
		this.scale=scale;
		piano = new Piano(scale);
	}
	
	public Integer gammeRight(Integer currentNote)
	{
		Integer index = new Integer(currentNote);
		Counter count = new Counter(index);
		
		for(int i=0;i<8;i++)
		{
			count.increment(1);
			System.out.println(piano.getPiano(index));
			melody.add(piano.getPiano(index));
		}
		
		return count.getValue();
	}
	
	public Integer gammeLeft(Integer currentNote)
	{
		Integer index = new Integer(currentNote);
		Counter count = new Counter(index);

		for(int i=0;i<7;i++)
		{
			count.decrement(1);
			System.out.println(piano.getPiano(index));
			melody.add(piano.getPiano(index));
		}
		
		return count.getValue();
	}
	
	public Integer tierceRight(Integer currentNote,int nbrNotes)
	{
		Integer index = new Integer(currentNote);
		Counter count = new Counter(index);
		
		for(int i=0;i<nbrNotes;i++)
		{
			count.increment(2);
			System.out.println(piano.getPiano(index));
			melody.add(piano.getPiano(index));
		}
		
		return count.getValue();
	}
	
	public Integer tierceLeft(Integer currentNote,int nbrNotes)
	{
		Integer index = new Integer(currentNote);
		Counter count = new Counter(index);
		
		for(int i=0;i<nbrNotes;i++)
		{
			count.decrement(2);
			System.out.println(piano.getPiano(index));
			melody.add(piano.getPiano(index));
		}
		
		return count.getValue();
	}
	
	public Integer motif1Right(Integer currentNote)
	{
		Integer index = new Integer(currentNote);
		Counter count = new Counter(index);
		
		melody.add(piano.getPiano(index));
		
		count.increment(4);
		melody.add(piano.getPiano(index));
		
		count.decrement(2);		
		melody.add(piano.getPiano(index));
		
		count.increment(2);
		melody.add(piano.getPiano(index));
		
		count.decrement(4);
		
		return count.getValue();
	}
	
	public Integer motif1Left(Integer currentNote)
	{
		Integer index = new Integer(currentNote);
		Counter count = new Counter(index);
		
		melody.add(piano.getPiano(index));
		
		count.decrement(4);
		melody.add(piano.getPiano(index));
		
		count.increment(2);
		melody.add(piano.getPiano(index));
		
		count.decrement(2);
		melody.add(piano.getPiano(index));
		
		count.increment(4);
		
		return count.getValue();
	}
	
	public Integer motif2Right(Integer currentNote)
	{
		Integer index = new Integer(currentNote);
		Counter count = new Counter(index);
		
		melody.add(piano.getPiano(index));
		
		count.increment(2);
		melody.add(piano.getPiano(index));
		
		count.decrement(1);
		melody.add(piano.getPiano(index));
		
		count.decrement(1);
		melody.add(piano.getPiano(index));
		
		count.increment(4);
		melody.add(piano.getPiano(index));
		
		count.decrement(4);
		
		return count.getValue();
	}
	
	public Integer motifalea(Integer currentNote, int nbrNote)
	{
		Integer position = currentNote;
		Counter count = new Counter(position);
		
		for(int i=0;i<nbrNote;i++)
		{
			int moreless=(int)( Math.random()*2);
			int nbIncre=(int)( Math.random()*100);
			
			if(nbIncre<=50)
				nbIncre=1;// ton : 50% de chance d'apparaitre
			else if((nbIncre>50)&&(nbIncre<80))
				nbIncre=2;//tierce : 30% 
			else if((nbIncre>=80)&&(nbIncre<88))
				nbIncre=3;//quarte : 8% 
			else if((nbIncre>=88)&&(nbIncre<95))
				nbIncre=4;//quinte : 7%
			else if((nbIncre>=95)&&(nbIncre<=100))
				nbIncre=0;//unisson : 5%

			if((moreless==0)&&(position<50))//a partir de la 50e note, on ne peut que dï¿½crï¿½menter
			{
				count.increment(nbIncre);
			}
			else if((moreless==1)&&(position>=20))//avant la 20e note, on ne peux que incrï¿½menter pour ï¿½viter d'avoir des sons trop grave
			{
				count.decrement(nbIncre);
			}
			
			else if((moreless==0)&&(position>=50))//en revanche si on veut incrémenter après 50 on peut pas, il faut alors décrémenter
			{
				count.decrement(nbIncre);
			}
			
			else if((moreless==1)&&(position<20))//et inversement
			{
				count.increment(nbIncre);
			}
			
			melody.add(piano.getPiano(count.getValue()));

		}
		
		return count.getValue();
	}

	public Integer conGammeRight(Integer currentNote, int nbrNote)
	{
		Integer index = new Integer(currentNote);
		Counter count = new Counter(index);
		
		for(int i=0;i<nbrNote;i++)
		{
			count.increment(1);
			melody.add(piano.getPiano(index));
		}
		
		return count.getValue();
	}
	
	public Integer conGammeLeft(Integer currentNote, int nbrNote)
	{
		Integer index = new Integer(currentNote);
		Counter count = new Counter(index);
		
		for(int i=0;i<nbrNote;i++)
		{
			count.decrement(1);
			melody.add(piano.getPiano(index));
		}
		
		return count.getValue();
	}
	
	public Integer centred(Integer currentNote, int nbrNote)
	{
		Integer position = currentNote;
		Counter count = new Counter(position);
		
		for(int i=0;i<nbrNote;i++)
		{
			count.setValue(currentNote);
			
			int moreless=(int)( Math.random()*2);
			int nbIncre=(int)( Math.random()*100);
			
			if(nbIncre<=50)
				nbIncre=1;// ton : 50% de chance d'apparaitre
			else if((nbIncre>50)&&(nbIncre<80))
				nbIncre=2;//tierce : 30% 
			else if((nbIncre>=80)&&(nbIncre<88))
				nbIncre=3;//quarte : 8% 
			else if((nbIncre>=88)&&(nbIncre<95))
				nbIncre=4;//quinte : 7%
			else if((nbIncre>=95)&&(nbIncre<=100))
				nbIncre=0;//unisson : 5%

			if((moreless==0)&&(position<50))//a partir de la 50e note, on ne peut que dï¿½crï¿½menter
			{
				count.increment(nbIncre);
			}
			
			else if((moreless==1)&&(position>=20))//avant la 20e note, on ne peux que incrï¿½menter pour ï¿½viter d'avoir des sons trop grave
			{
				count.decrement(nbIncre);
			}
			
			else if((moreless==0)&&(position>=50))//en revanche si on veut incrémenter après 50 on peut pas, il faut alors décrémenter
			{
				count.decrement(nbIncre);
			}
			
			else if((moreless==1)&&(position<20))//et inversement
			{
				count.increment(nbIncre);
			}
			
			melody.add(piano.getPiano(count.getValue()));

		}
		
		return count.getValue();
	}
}
