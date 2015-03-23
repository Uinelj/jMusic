import java.util.LinkedList;

import notes.RythmicNote;
import players.NotePlayer;
import players.ThreadedNotePlayer;
import rythm.Rythm;
import rythm.TimeSignature;


public class percuTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadedNotePlayer percuPlayer = new ThreadedNotePlayer(new NotePlayer(9, 50, new Rythm(new TimeSignature(4, 4, 120))));
		LinkedList<RythmicNote> toast = new LinkedList<RythmicNote>();
		toast.add(new RythmicNote(33, 4));
		percuPlayer.play(toast);
	}
}
