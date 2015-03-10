package scales;
import java.util.ArrayList;

import modes.Mode;
import notes.HarmonicNote;
import notes.Note;
import notes.RythmicNote;


public class Scale {
	
	private Mode mode;
	private HarmonicNote fundamental;
	private ArrayList<HarmonicNote> notes;
	
	public Scale(HarmonicNote fundamental, Mode mode){
		
		this.mode = mode;
		this.fundamental = fundamental;
		notes = new ArrayList<HarmonicNote>();
		notes.add(0, fundamental);
		//System.out.println(notes.get(0));
		//System.out.println(mode.getIntervals());
		for(int i=1; i<mode.getIntervals().size(); i++){
			notes.add(i, new HarmonicNote(notes.get(i-1).getHeight()+mode.getIntervals().get(i-1)));
		}
		//System.out.println(notes.toString());
	}
	
	public ArrayList<HarmonicNote> getNotes(){
		return notes;
	}
	public HarmonicNote getDegree(int degree){ //First degree : 1
		return notes.get((degree-1)%notes.size());
	}
	public HarmonicNote getFundamental(){
		return fundamental;
	}
	public String toString(){
		String ret="";
		for(HarmonicNote note : notes){
			ret+=note.getHeight();
		}
		return ret;
	}
	public ArrayList<RythmicNote> toRythmicNote(int length){
		ArrayList<RythmicNote> ret = new ArrayList<RythmicNote>();
		for(HarmonicNote note : notes){
			ret.add(new RythmicNote(note.getHeight(), length));
		}
		return ret;
	}
	public ArrayList<RythmicNote> toRythmicNote(){
		return toRythmicNote(4);
	}
}