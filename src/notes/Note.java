//Dernier changement le 19/02/2015

package notes;

/**
 *classe abstraite pour lier harmoniques et rythmiques notes
 * @author JOHAN
 *
 */
public abstract class Note {
	
	private int height;
	
	/**
	 * 
	 */
	public Note(){
	}

	
	/**
	 * @return lq hauteur de la note en integer
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height set la hauteur de la note
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
}
