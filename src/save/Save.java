package save;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import melody.rythmicMelody.RythmicMelody;

public class Save {
	
	private String path;//chemin du fichier à creer pour sauvegarder
	private RythmicMelody melody;//melody à enregistrer
	
	public Save(String path, RythmicMelody melody)
	{
		this.setPath(path);
	    this.setMelody(melody);
	}
	
	public void save(String path,RythmicMelody melody)//sauvegarder
	{
		File file = new File(path);
		try{
	         ObjectOutputStream flotEcriture = new ObjectOutputStream(new FileOutputStream(file));//ouverture d'un fichier où écrire la sauvegarde
	         flotEcriture.writeObject(melody);//écriture
	         flotEcriture.close();//on ferme le flux
		}
	       catch (IOException e) {
	         System.out.println(" erreur :" + e.toString());
	       }   
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public RythmicMelody getMelody() {
		return melody;
	}

	public void setMelody(RythmicMelody melody) {
		this.melody = melody;
	}

}
