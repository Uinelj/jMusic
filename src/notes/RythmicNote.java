//Dernier changement le 19/02/2015

/*
 RythmicNote(height(int); lenght(int))

type: 	
	0 : triple croche
	1 : double croche
	2 : trillolet
	3 : croche
	4 : noire
	5 : noire point�e
	6 : blanche
	7 : blanche point�e
	8 : ronde
	9 : ronde point�e
 */

package notes;

public class RythmicNote extends Note {
	
	private int length;							
	
	public RythmicNote(int height, int length){
		super.setHeight(height);
		this.length = length;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	public int getHeight() {
		return super.getHeight();
	}

	public void setHeight(int height) {
		super.setHeight(height);
	}
}
