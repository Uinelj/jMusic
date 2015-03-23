import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import modes.Mode;
import notes.HarmonicNote;
import players.ChordLoopPlayer;
import players.ChordPlayer;
import players.NotePlayer;
import players.ThreadedChordPlayer;
import players.ThreadedNotePlayer;
import rythm.Rythm;
import rythm.TimeSignature;
import scales.Scale;
import chords.Chord;
import chords.ChordLoop;
import chords.ChordLoopGenerator;

public class mainTest {
	public static void main(String[] args) {
		Rythm r = new Rythm(new TimeSignature(4, 4, 120));
		ThreadedChordPlayer tcp = new ThreadedChordPlayer(new ChordLoopPlayer(1, 16, r));
		ThreadedNotePlayer tnp = new ThreadedNotePlayer(new NotePlayer(1, 1, r));
		
		Scale doMaj = new Scale(new HarmonicNote(60), new Mode(1));
		ChordLoopGenerator doMajChords = new ChordLoopGenerator(doMaj);
		ChordLoopGenerator relativeChords = new ChordLoopGenerator(doMaj.getRelativeScale());
		ChordLoop buf = new ChordLoop(doMajChords.getPrettyChordSuite(8));
		buf.add(relativeChords.getPrettyChordSuite(6));
		
		//tcp.play(buf.getBuffer());
		
		Scale laMin = new Scale(new HarmonicNote(65), new Mode(6));
		ChordLoopGenerator clg = new ChordLoopGenerator(doMaj);
		buf.add(clg.getModulationChords(laMin, 2));
		ChordLoopGenerator clg2 = new ChordLoopGenerator(laMin);
		buf.add(clg2.getPrettyChordSuite(8));
		buf.add(clg2.getModulationChords(doMaj, 2));
		System.out.println(buf);
		tcp.play(buf.getBuffer());
		
	}
}