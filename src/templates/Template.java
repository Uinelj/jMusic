//Dernier changement de 26/02/2015

package templates;
import java.util.ArrayList;
import notes.RythmicNote;

public abstract class Template {
	
	private ArrayList<RythmicNote> notes = new ArrayList<RythmicNote>();

	public ArrayList<RythmicNote> getTemplate() {
		return notes;
	}
	public void setTemplate(ArrayList<RythmicNote> notes) {
		this.notes = notes;
	}
	
}