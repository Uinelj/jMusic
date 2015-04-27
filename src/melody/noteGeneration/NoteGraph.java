package melody.noteGeneration;

import scales.Scale;
import melody.Graph;
import melody.rythmicMelody.RythmGraph;
import modes.Mode;

public class NoteGraph {
	
	Graph g;

	public NoteGraph()
	{
		g= new Graph(7,15);
		init_table();
	}

	private void init_table()
	{
		
		g.addValue(0, 0, 10);
		g.addValue(0, 1, 7);
		g.addValue(0, 2, 15);
		g.addValue(0, 3, 5);
		g.addValue(0, 4, 11);
		g.addValue(0, 5, 3);
		g.addValue(0, 6, 2);
		g.addValue(0, 7, 2);
		g.addValue(0, 8, 7);
		g.addValue(0, 9, 15);
		g.addValue(0, 10, 5);
		g.addValue(0, 11, 11);
		g.addValue(0, 12, 3);
		g.addValue(0, 13, 2);
		g.addValue(0, 14, 2);

		g.addValue(1, 0, 10);
		g.addValue(1, 1, 7);
		g.addValue(1, 2, 15);
		g.addValue(1, 3, 5);
		g.addValue(1, 4, 11);
		g.addValue(1, 5, 3);
		g.addValue(1, 6, 2);
		g.addValue(1, 7, 2);
		g.addValue(1, 8, 7);
		g.addValue(1, 9, 15);
		g.addValue(1, 10, 5);
		g.addValue(1, 11, 11);
		g.addValue(1, 12, 3);
		g.addValue(1, 13, 2);
		g.addValue(1, 14, 2);
		
		g.addValue(2, 0, 10);
		g.addValue(2, 1, 7);
		g.addValue(2, 2, 15);
		g.addValue(2, 3, 5);
		g.addValue(2, 4, 11);
		g.addValue(2, 5, 3);
		g.addValue(2, 6, 2);
		g.addValue(2, 7, 2);
		g.addValue(2, 8, 7);
		g.addValue(2, 9, 15);
		g.addValue(2, 10, 5);
		g.addValue(2, 11, 11);
		g.addValue(2, 12, 3);
		g.addValue(2, 13, 2);
		g.addValue(2, 14, 2);
		
		g.addValue(3, 0, 10);
		g.addValue(3, 1, 7);
		g.addValue(3, 2, 15);
		g.addValue(3, 3, 5);
		g.addValue(3, 4, 11);
		g.addValue(3, 5, 3);
		g.addValue(3, 6, 2);
		g.addValue(3, 7, 2);
		g.addValue(3, 8, 7);
		g.addValue(3, 9, 15);
		g.addValue(3, 10, 5);
		g.addValue(3, 11, 11);
		g.addValue(3, 12, 3);
		g.addValue(3, 13, 2);
		g.addValue(3, 14, 2);
		
		g.addValue(4, 0, 10);
		g.addValue(4, 1, 7);
		g.addValue(4, 2, 15);
		g.addValue(4, 3, 5);
		g.addValue(4, 4, 11);
		g.addValue(4, 5, 3);
		g.addValue(4, 6, 2);
		g.addValue(4, 7, 2);
		g.addValue(4, 8, 7);
		g.addValue(4, 9, 15);
		g.addValue(4, 10, 5);
		g.addValue(4, 11, 11);
		g.addValue(4, 12, 3);
		g.addValue(4, 13, 2);
		g.addValue(4, 14, 2);
		
		g.addValue(5, 0, 10);
		g.addValue(5, 1, 7);
		g.addValue(5, 2, 15);
		g.addValue(5, 3, 5);
		g.addValue(5, 4, 11);
		g.addValue(5, 5, 3);
		g.addValue(5, 6, 2);
		g.addValue(5, 7, 2);
		g.addValue(5, 8, 7);
		g.addValue(5, 9, 15);
		g.addValue(5, 10, 5);
		g.addValue(5, 11, 11);
		g.addValue(5, 12, 3);
		g.addValue(5, 13, 2);
		g.addValue(5, 14, 2);
		
		g.addValue(6, 0, 10);
		g.addValue(6, 1, 7);
		g.addValue(6, 2, 15);
		g.addValue(6, 3, 5);
		g.addValue(6, 4, 11);
		g.addValue(6, 5, 3);
		g.addValue(6, 6, 2);
		g.addValue(6, 7, 2);
		g.addValue(6, 8, 7);
		g.addValue(6, 9, 15);
		g.addValue(6, 10, 5);
		g.addValue(6, 11, 11);
		g.addValue(6, 12, 3);
		g.addValue(6, 13, 2);
		g.addValue(6, 14, 2);

			
				
		
	}


	public int getProba(int i, int j)
	{
		return g.getProba(i, j);
	}
}