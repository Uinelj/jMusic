package save;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import melody.rythmicMelody.RythmicMelody;

public class Load {

	private String path;//chemin du fichier de sauvegarde
	private RythmicMelody melody;//melody sur laquelle on ajoute les données du fichier de sauvegarde
	
	public Load(String path)
	{
		this.setPath(path);
	}
	
	public void load(String path)//chargement de la mélodie
	{
		try{
			ObjectInputStream flotLecture = new ObjectInputStream(new FileInputStream("melody"));//ouverture du fichier de sauvegarde
			melody=(RythmicMelody)flotLecture.readObject();//lecture du fichier de sauvegarde
			flotLecture.close();//fermeture du flux
		}
		
		catch (IOException e) {
	         System.out.println(" erreur :" + e.toString());
	       }  
		
		catch (ClassNotFoundException e2){
	         System.out.println(" erreur :" + e2.toString());
		}
	}
	public RythmicMelody getRythmicMelody()
	{
		return melody;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
