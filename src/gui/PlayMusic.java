package gui;

import melody.rythmicMelody.RythmicMelodyGenerator;
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

public class PlayMusic {
	public PlayMusic(int[] options){
		Rythm rythm = new Rythm(new TimeSignature(4, 4, 100));
		ThreadedChordPlayer tcp = new ThreadedChordPlayer(new ChordLoopPlayer(1, 12, rythm));
		ThreadedNotePlayer tnp = new ThreadedNotePlayer(new NotePlayer(2, 12, rythm));
		
		Scale scale = new Scale(new HarmonicNote(options[0]), new Mode(options[1]));
		
		RythmicMelodyGenerator rmg = new RythmicMelodyGenerator(scale, 400);
		ChordLoopGenerator clg = new ChordLoopGenerator(scale);
		
		rmg.basicMelody();
		ChordLoop cl = new ChordLoop(clg.getPrettyChordSuite(4));
		
		tnp.play(rmg.GetRythmicMelody());
		tcp.play(cl.getBuffer());
	}
}
