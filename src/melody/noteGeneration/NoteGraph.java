package melody.noteGeneration;

import scales.Scale;
import melody.Graph;
import melody.rythmicMelody.RythmGraph;
import modes.Mode;
/**
 * classe de traitement : rempli les graphes de probabilités
 *
 * @author AKTOR Alexis
 *
 */
public class NoteGraph {
	
	Graph g;

	public NoteGraph()
	{
		g= new Graph(8,15);
		init_table();
	}

	private void init_table()
	{
		
		g.addValue(0, 0, 10);
		g.addValue(0, 1, 15);
		g.addValue(0, 2, 20);
		g.addValue(0, 3, 8);
		g.addValue(0, 4, 20);
		g.addValue(0, 5, 5);
		g.addValue(0, 6, 1);
		g.addValue(0, 7, 1);
		g.addValue(0, 8, 8);
		g.addValue(0, 9, 5);
		g.addValue(0, 10, 4);
		g.addValue(0, 11, 1);
		g.addValue(0, 12, 1);
		g.addValue(0, 13, 1);
		g.addValue(0, 14, 0);

		g.addValue(1, 0, 10);
		g.addValue(1, 1, 13);
		g.addValue(1, 2, 18);
		g.addValue(1, 3, 6);
		g.addValue(1, 4, 18);
		g.addValue(1, 5, 3);
		g.addValue(1, 6, 1);
		g.addValue(1, 7, 1);
		g.addValue(1, 8, 10);
		g.addValue(1, 9, 7);
		g.addValue(1, 10, 6);
		g.addValue(1, 11, 3);
		g.addValue(1, 12, 2);
		g.addValue(1, 13, 1);
		g.addValue(1, 14, 1);
		
		g.addValue(2, 0, 10);
		g.addValue(2, 1, 11);
		g.addValue(2, 2, 16);
		g.addValue(2, 3, 4);
		g.addValue(2, 4, 16);
		g.addValue(2, 5, 1);
		g.addValue(2, 6, 1);
		g.addValue(2, 7, 1);
		g.addValue(2, 8, 12);
		g.addValue(2, 9, 9);
		g.addValue(2, 10, 8);
		g.addValue(2, 11, 5);
		g.addValue(2, 12, 4);
		g.addValue(2, 13, 1);
		g.addValue(2, 14, 1);
		
		g.addValue(3, 0, 10);
		g.addValue(3, 1, 10);
		g.addValue(3, 2, 15);
		g.addValue(3, 3, 3);
		g.addValue(3, 4, 14);
		g.addValue(3, 5, 1);
		g.addValue(3, 6, 1);
		g.addValue(3, 7, 1);
		g.addValue(3, 8, 13);
		g.addValue(3, 9, 10);
		g.addValue(3, 10, 9);
		g.addValue(3, 11, 6);
		g.addValue(3, 12, 5);
		g.addValue(3, 13, 1);
		g.addValue(3, 14, 1);
		
		g.addValue(4, 0, 10);
		g.addValue(4, 1, 12);
		g.addValue(4, 2, 9);
		g.addValue(4, 3, 8);
		g.addValue(4, 4, 5);
		g.addValue(4, 5, 4);
		g.addValue(4, 6, 1);
		g.addValue(4, 7, 1);
		g.addValue(4, 8, 11);
		g.addValue(4, 9, 16);
		g.addValue(4, 10, 4);
		g.addValue(4, 11, 16);
		g.addValue(4, 12, 1);
		g.addValue(4, 13, 1);
		g.addValue(4, 14, 1);
		
		g.addValue(5, 0, 10);
		g.addValue(5, 1, 10);
		g.addValue(5, 2, 7);
		g.addValue(5, 3, 6);
		g.addValue(5, 4, 3);
		g.addValue(5, 5, 2);
		g.addValue(5, 6, 1);
		g.addValue(5, 7, 1);
		g.addValue(5, 8, 13);
		g.addValue(5, 9, 18);
		g.addValue(5, 10, 6);
		g.addValue(5, 11, 18);
		g.addValue(5, 12, 3);
		g.addValue(5, 13, 1);
		g.addValue(5, 14, 1);
		
		g.addValue(6, 0, 10);
		g.addValue(6, 1, 8);
		g.addValue(6, 2, 5);
		g.addValue(6, 3, 4);
		g.addValue(6, 4, 1);
		g.addValue(6, 5, 1);
		g.addValue(6, 6, 1);
		g.addValue(6, 7, 0);
		g.addValue(6, 8, 15);
		g.addValue(6, 9, 20);
		g.addValue(6, 10, 8);
		g.addValue(6, 11, 20);
		g.addValue(6, 12, 5);
		g.addValue(6, 13, 1);
		g.addValue(6, 14, 1);

		g.addValue(7, 0, 10);
		g.addValue(7, 1, 7);
		g.addValue(7, 2, 15);
		g.addValue(7, 3, 5);
		g.addValue(7, 4, 11);
		g.addValue(7, 5, 3);
		g.addValue(7, 6, 2);
		g.addValue(7, 7, 2);
		g.addValue(7, 8, 7);
		g.addValue(7, 9, 15);
		g.addValue(7, 10, 5);
		g.addValue(7, 11, 11);
		g.addValue(7, 12, 3);
		g.addValue(7, 13, 2);
		g.addValue(7, 14, 2);
				
		
	}


	public int getProba(int i, int j)
	{
		return g.getProba(i, j);
	}
}