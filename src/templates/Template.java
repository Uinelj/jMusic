//Dernier changement de 26/02/2015

package templates;
import java.util.ArrayList;
import notes.RythmicNote;

/**
 * @author JOHAN
 *classe abstraite de template
 */
public abstract class Template {
	
	private ArrayList<RythmicNote> notes = new ArrayList<RythmicNote>();

	/**
	 * @return la arraylist de rythmicnotes du template
	 */
	public ArrayList<RythmicNote> getTemplate() {
		return notes;
	}
	/**
	 * @param notes set la arraylist de rythmicnotes du template
	 */
	public void setTemplate(ArrayList<RythmicNote> notes) {
		this.notes = notes;
	}
	
}