package players;

import java.util.LinkedList;

import notes.RythmicNote;
import rythm.Rythm;

/**
 * @author Julien ABADJI
 *	Permet de lire une liste chaînée de notes, en les envoyant au Player(RythmicNote).
 *	C'est un Thread, ce qui permet de lire les notes en même temps que les accords se lisent. 
 */
public class NotePlayer extends Player implements Runnable{
	LinkedList<RythmicNote> notes;
	public NotePlayer(int channel, int instrument, Rythm rythm){
		super(channel, instrument, rythm);
	}

	
	public void fill(LinkedList<RythmicNote> notes){
		this.notes = notes;
	}


	@Override
	public void run() {
		try {
			while(!notes.isEmpty()){ //Tant que la LinkedList n'est pas vide, on la lit.
					play(notes.removeFirst());
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		
		}
	}
}
