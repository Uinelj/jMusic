package melody.tools;
import java.util.LinkedList;
import notes.RythmicNote;
/*Classe qui sert à créer une sous LinkedList pour pouvoir la rajouter dans la mélodie
		exemple : pour mettre un thème, un couplet, un motif etc...
*/
public class Repetition 
{
	LinkedList<RythmicNote> sentence;
	
	public Repetition()
	{
		sentence = new LinkedList<RythmicNote>();
	}
	
	public void add(RythmicNote note)
	{
		sentence.add(note);
	}
	
	public RythmicNote removeFirst()
	{
		return sentence.remove();
	}

	public LinkedList<RythmicNote> getSentence()
	{
		return sentence;
	}
	
	
	@Override
	public String toString() {
		String str = "";
		for(int i=0;i<sentence.size();i++)
		{
			str = str+sentence.get(i).getHeight();
		}
		return str;
	}
}
