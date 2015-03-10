package melody;
import java.util.LinkedList;
import notes.HarmonicNote;

	public class Melody {
		
		private LinkedList<HarmonicNote> melody = new LinkedList<HarmonicNote>();//Fifo contenant les notes g�n�r�e proceduralement
		public Melody()
		{
			melody= new LinkedList<HarmonicNote>();
		}
		
		public LinkedList<HarmonicNote> getMelody()
		{
			return melody;
		}
		
		public void add(HarmonicNote harmonicNote)
		{
			melody.add(harmonicNote);
		}
		
		public HarmonicNote removeFirst()
		{
			return melody.remove();
		}
		
		
		public HarmonicNote getFirst()
		{
			return melody.getFirst();
		}
		
		public String toString()
		{
			String str="notes g�n�r�es proc�duralement";
			for(int i=0;i<melody.size();i++)
			{
				str=str+" "+melody.get(i).getHeight();
			}
			return str;
		}
		
		
	}


