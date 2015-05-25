package melody.rythmicMelody;
import java.io.Serializable;
/**
 * classe de donnée : gère une file de rythmicNote
 *
 * @author AKTOR Alexis
 *
 */
import java.util.LinkedList;

import templates.Template;
import notes.*;
public class RythmicMelody implements Serializable{

	private LinkedList<RythmicNote> rythmicMelody;//la mï¿½lodie va remplir ces templates
	
	public RythmicMelody()
	{		rythmicMelody = new LinkedList<RythmicNote>();
	}
	
	public LinkedList<RythmicNote> getRythmicMelody()
	{
		return rythmicMelody;
	}
	public void addAll(LinkedList<RythmicNote> rythmicMelody){
		this.rythmicMelody.addAll(rythmicMelody);
	}
	
	public RythmicNote removeFirst()
	{
		return rythmicMelody.removeFirst();
	}
	
	public void addRythmicNote(RythmicNote rythmicNote)
	{
		rythmicMelody.add(rythmicNote);
	}
	
	public void addTemplate(Template template)
	{
		int size=template.getTemplate().size();
		for(int i=0;i<size;i++)
		{
			rythmicMelody.add(template.getTemplate().get(i));
			
		}
	
	}
	
	public String toString()
	{
		String str=" ";
		for(int i=0; i< rythmicMelody.size();i++)
		{
			str="  "+str+rythmicMelody.get(i).getHeight()+"dure : "+rythmicMelody.get(i).getLength()+" ";
		}
		return str;
	}

}
