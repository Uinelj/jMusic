package players;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

import chords.Chord;
import notes.RythmicNote;
import rythm.Rythm;
//TODO: Voir si c'est a la classe de tryCatch ou juste de throw.
public class Player{
	//ArrayList<T> buffer;
	private int channel; //Channel to play. Different for chords and melody. 
	private int instrument; //Instrument played by the player. See internet for the available instruments. 
	private Synthesizer synth; //these two attrubutes manage the midi interactions. 
	private MidiChannel midiChannel;
	private Rythm rythm;
	
	public Player(int channel, int instrument, Rythm rythm){
		this.channel = channel;
		try {
			synth = MidiSystem.getSynthesizer(); //MIDI stuff
            synth.open();
        } catch (MidiUnavailableException ex) {
           ex.printStackTrace();
        }
        midiChannel = synth.getChannels()[channel]; //MORE MIDI STUFF.
        midiChannel.programChange(instrument);
        this.rythm = rythm;
        try {
			play(new RythmicNote(60, 2));
			play(new RythmicNote(67, 4));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void play(RythmicNote note) throws InterruptedException {
		midiChannel.noteOn(note.getHeight(), 100);
		TimeUnit.MILLISECONDS.sleep((long)rythm.convertTime(note.getLength()));
		midiChannel.noteOff(note.getHeight());

	}
	protected void play(Chord chord)throws InterruptedException {
		long timer = (long)rythm.convertTime(chord.toRythmicNote().get(0).getLength());
		for(RythmicNote note : chord.toRythmicNote()){
			midiChannel.noteOn(note.getHeight(), 60);
		}
		TimeUnit.MILLISECONDS.sleep(timer);
		midiChannel.allNotesOff();
	}
	
	public void stopPlayer(){
		
		this.midiChannel.allNotesOff();
	}
}
