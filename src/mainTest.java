import java.util.concurrent.TimeUnit;

import modes.Mode;
import notes.HarmonicNote;
import players.ChordLoopPlayer;
import players.NotePlayer;
import players.ThreadedChordPlayer;
import players.ThreadedNotePlayer;
import rythm.Rythm;
import rythm.TimeSignature;
import scales.Scale;
import chords.ChordLoop;
import chords.ChordLoopGenerator;

public class mainTest {
	public static void main(String[] args) {
		Rythm r = new Rythm(new TimeSignature(4, 4, 120));
		ThreadedChordPlayer tcp = new ThreadedChordPlayer(new ChordLoopPlayer(1, 1, r));
		ThreadedNotePlayer tnp = new ThreadedNotePlayer(new NotePlayer(1, 1, r));
		
		Scale doMaj = new Scale(new HarmonicNote(60), new Mode(1));
		Scale laMin = doMaj.getRelativeScale();
		ChordLoopGenerator clg = new ChordLoopGenerator(laMin);
		ChordLoop cl = new ChordLoop(clg.getPrettyChordSuite(4));
		System.out.println(laMin);
		
		tcp.play(cl.getBuffer());
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tcp.stop();
		ChordLoopGenerator clg2 = new ChordLoopGenerator(laMin);
		ChordLoop cl2 = new ChordLoop(clg2.getPrettyChordSuite(4));
		tcp.play(cl2.getBuffer());
	}
}