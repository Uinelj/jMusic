package melody.rythmicMelody;
import java.util.LinkedList;
import notes.RythmicNote;

public abstract class RythmicMelodyGenerator {
	
	private RythmicMelody rythmicMelody;
	abstract void basicMelody();

	
	protected LinkedList<RythmicNote> GetRythmicMelody()
	{
		return rythmicMelody.getRythmicMelody();
	}
}