import java.util.LinkedList;

import modes.Mode;
import notes.HarmonicNote;
import notes.RythmicNote;
import players.ChordLoopPlayer;
import players.NotePlayer;
import players.ThreadedChordPlayer;
import players.ThreadedNotePlayer;
import rythm.Rythm;
import rythm.TimeSignature;
import scales.Scale;

public class mainTest {
	public static void main(String[] args) {
		Rythm r = new Rythm(new TimeSignature(4, 4, 120));
		ThreadedChordPlayer tcp = new ThreadedChordPlayer(new ChordLoopPlayer(1, 12, r));
		ThreadedNotePlayer tnp = new ThreadedNotePlayer(new NotePlayer(1, 1, r));
		LinkedList<RythmicNote> buf = new LinkedList<RythmicNote>();
		Scale doMaj = new Scale(new HarmonicNote(60), new Mode(10));
		
		for(int i=0; i<doMaj.toRythmicNote().size(); i++){
			buf.add(doMaj.toRythmicNote().get(i));
		}
		tnp.play(buf);
	}
}