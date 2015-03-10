import java.util.ArrayList;
import modes.Mode;
import notes.HarmonicNote;
import notes.Note;
import notes.RythmicNote;
import templates.SyncopeTemplate;
import templates.Template;
import gui.Window;


public class testSpecificMode {
	public static void main(String[] args){
		Mode mode = new Mode(12); //voila comment on créé un mode désormais mes amours.
		ArrayList<HarmonicNote> templateNotes = new ArrayList<HarmonicNote>();
		HarmonicNote note = new HarmonicNote(60);
		HarmonicNote note1 = new HarmonicNote(57);
		templateNotes.add(note);
		templateNotes.add(note1);
		templateNotes.add(note1);
		templateNotes.add(note1);
		templateNotes.add(note1);
		Template trille = new SyncopeTemplate(templateNotes);
		System.out.println(mode.getIntervals());
		System.out.println(trille.getTemplate());
		
		Window window = new Window();
	}
}
