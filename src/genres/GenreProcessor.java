package genres;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import javax.xml.xpath.XPathExpressionException;

import players.ChordPlayer;
import players.NotePlayer;
import players.Player;
import players.ThreadedChordPlayer;
import players.ThreadedNotePlayer;
import melody.noteGeneration.Melody;
import melody.noteGeneration.MelodyGenerator;
import melody.rythmicMelody.RythmicMelody;
import melody.rythmicMelody.RythmicMelodyGenerator;
import modes.Mode;
import notes.HarmonicNote;
import rythm.Rythm;
import rythm.TimeSignature;
import scales.Scale;
import chords.Chord;
import chords.ChordLoopGenerator;

/**
 * @author Julien ABADJI
 *
 *	Applique des transformations aléatoires aux genres, les prépare à être lus et les lit.
 */
public class GenreProcessor {
	private Genre genre;
	HarmonicNote baseNote;
	Boolean isProcessed = false;
	Boolean isComposed = false;
	Song song;
	public GenreProcessor(Genre genre) {
		this.genre = genre;
		// TODO Auto-generated constructor stub
	}
	public GenreProcessor(String name) throws XPathExpressionException{
		this.genre = new Genre(name);
	}
	
	/**
	 * Applique les transformations aléatoires. 
	 */
	public void process(){
		Random rand = new Random(); //On initialise notre facteur aléatoire
		int tempo = rand.nextInt(genre.getMaxTempo()-genre.getMinTempo()+1) + genre.getMinTempo();
		Integer melodyInstrument = rand.nextInt(genre.getMelodyInstruments().size());
		Integer chordInstrument = rand.nextInt(genre.getChordInstruments().size());
		baseNote = new HarmonicNote(rand.nextInt(25)+36);//
		genre.setMinTempo(tempo);
		genre.setMaxTempo(tempo);
		genre.setMelodyInstruments(melodyInstrument);
		genre.setChordInstruments(chordInstrument);
		isProcessed = true;
	}
	
	/**
	 * Va composer et assembler la "chanson" finale. 
	 */
	@SuppressWarnings("unchecked") //A cause d'un clone de ArrayList.
	public void compose(){
		if(isProcessed){
			/*
			 * Détermine les gammes utilisées
			 * */
			Scale melodyScale = new Scale(new HarmonicNote(baseNote.getHeight()+12), new Mode(genre.getMelodyMode()));
			Scale chordScale = new Scale(baseNote, new Mode(genre.getChordsMode()));
			/*
			 * Les listes à remplir, qui composeront la chanson.
			 * */
			LinkedList<Chord> songChords = new LinkedList<Chord>();
			RythmicMelody songMelody = new RythmicMelody();
			
			/*
			 * Initialisation des générateurs d'accord et de mélodie
			 * */
			ChordLoopGenerator clg = new ChordLoopGenerator(chordScale, genre.getChordStructure());
			MelodyGenerator mg = new MelodyGenerator(melodyScale, 100);
			mg.generateMelody(40);
			RythmicMelodyGenerator rmg = new RythmicMelodyGenerator(mg.getMelody(), melodyScale, 30, new TimeSignature(4, 4, 120));
			RythmicMelody test = rmg.simpleGen(50);
			if(genre.getForm() != null){ //On veut donc une chanson structurée
				ArrayList<Character> formSet = new ArrayList<Character>();
				for(Character c : genre.getForm()){ // On détecte le nombre d'entités différentes : Exemple : ABAB -> 2 entités
					if(!formSet.contains(c)){
						formSet.add(c);
					}
				}
				/*
				 * On génère une ligne mélodique et des accords pour chaque entité détectée
				 * */
				ArrayList<ArrayList <Chord>> chordSamples = new ArrayList<ArrayList<Chord>>();
				ArrayList<RythmicMelody> melodySamples = new ArrayList<RythmicMelody>();
				
				ArrayList<Chord> chordsBuffer;
				RythmicMelody melodyBuffer;
				int sampleIndex;
				for(int i=0; i<formSet.size(); i++){
					chordsBuffer = clg.getPrettyChordSuite(genre.getFormLength());
					chordSamples.add( (ArrayList<Chord>) chordsBuffer.clone());
					/* Génération procédurale mélodie/accords */
					melodySamples.add(rmg.simpleGen(genre.getFormLength()));
					chordsBuffer.clear();
				}
				for(int i=0; i<genre.getForm().size(); i++){ //On assemble les différentes lignes générées.
					sampleIndex = formSet.indexOf(genre.getForm().get(i));
					songChords.addAll(chordSamples.get(sampleIndex));
					songMelody.addAll(melodySamples.get(sampleIndex).getRythmicMelody());
				}
			}else{ //Si on veut une progression, on ne génère que la mélodie.
				songMelody = rmg.simpleGen(genre.getProgression().size());
				for(Integer i : genre.getProgression()){
					songChords.add(clg.getChordCollection().getHarmonizedChords().get(i-1));
				}
			}
			song = new Song(songMelody, songChords, genre.getChordStyle()); //La chanson est composée !
			isComposed = true;
		}else{
			this.process();
			this.compose();
		}
	}
	
	/**
	 * Wrapper pour les players.
	 */
	public void play(){
		if(isProcessed && isComposed){
			Rythm r = new Rythm(new TimeSignature(4, 4, genre.getMinTempo()));
			ThreadedNotePlayer melody = new ThreadedNotePlayer(new NotePlayer(1, genre.getMelodyInstruments().get(0), r));
			ThreadedChordPlayer chords;
			ThreadedNotePlayer arpChords;
			
			switch(genre.getChordStyle()){ //Si les accords sont des arpèges, on utilise un NotePlayer.
				case "arp":
					chords = null;
					arpChords = new ThreadedNotePlayer(new NotePlayer(2, genre.getMelodyInstruments().get(0), r));
					break;
				default:
					chords = new ThreadedChordPlayer(new ChordPlayer(2, genre.getMelodyInstruments().get(0), r));
					arpChords = null;
					break;
			
			}
			
			if(melody != null){
				melody.play(song.getMelody().getRythmicMelody());
			}
			if(chords != null){
				chords.play(song.getChords());
			}else if(arpChords != null){
				arpChords.play(song.getArpChords());
			}
		}
	}
}
