package gui;



import melody.noteGeneration.MelodyGenerator;
import melody.rythmicMelody.RythmicMelodyGenerator;
import melody.rythmicMelody.RythmicMelody;
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

	
	private ThreadedChordPlayer tcp = null;
	private ThreadedNotePlayer tnp = null;

	private RythmicMelodyGenerator rmg = null;
	
	public PlayMusic(int[] options){

		

		System.out.println(options[8]);
		Rythm rythm = new Rythm(new TimeSignature(4, 4, options[11]));

		this.tcp = new ThreadedChordPlayer(new ChordLoopPlayer(1, options[9], rythm));
		this.tnp = new ThreadedNotePlayer(new NotePlayer(2, options[10], rythm));


		
		Scale scale = new Scale(new HarmonicNote(options[0]), new Mode(options[1]));

		MelodyGenerator melo = new MelodyGenerator(scale, options[8]);
		melo.generateMelody(30);
		this.rmg = new RythmicMelodyGenerator(melo.getMelody(),scale,options[8],new TimeSignature(4, 4, options[11]));
		
		

		ChordLoopGenerator clg = new ChordLoopGenerator(scale);
		
		rmg.generateRythmicMelody();
		ChordLoop cl = new ChordLoop(clg.getPrettyChordSuite(options[12]));
		
		tnp.play(rmg.GetRythmicMelody().getRythmicMelody());
		
		//melo.generateMelody(30);
		//rmg.setMelody(melo.getMelody());
		
		//tnp.play(rmg.GetRythmicMelody());
		tcp.play(cl.getBuffer());
	}
	
	public void stopMusic(){
		
		tcp.stop();
		tnp.stop();
		tcp.getChordPlayer().stopPlayer();
		tnp.getChordPlayer().stopPlayer();
		
		

	}


	
	public RythmicMelody getCurrentMelody(){
		
		return rmg.GetRythmicMelodyObject();
	}
	
}