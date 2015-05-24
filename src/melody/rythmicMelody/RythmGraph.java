package melody.rythmicMelody;

import melody.tools.ProbabilityTable;
import modes.Mode;

public class RythmGraph {
	
	private int table[][];
	
	public RythmGraph()
	{
		table = new int[10][10];
		init_table();
	}

	private void init_table()
	{
		//triple croche
		table[0][0]=0;
		table[0][1]=0;
		table[0][2]=0;
		table[0][3]=50;
		table[0][4]=50;
		table[0][5]=0;
		table[0][6]=0;
		table[0][7]=0;
		table[0][8]=0;
		table[0][9]=0;
		
		//double croche
		table[1][0]=0;
		table[1][1]=0;
		table[1][2]=0;
		table[1][3]=50;
		table[1][4]=50;
		table[1][5]=0;
		table[1][6]=0;
		table[1][7]=0;
		table[1][8]=0;
		table[1][9]=0;
		
		//tierce
		table[2][0]=0;
		table[2][1]=0;
		table[2][2]=0;
		table[2][3]=0;
		table[2][4]=0;
		table[2][5]=0;
		table[2][6]=0;
		table[2][7]=0;
		table[2][8]=0;
		table[2][9]=0;
		
		//croche
		table[3][0]=0;
		table[3][1]=0;
		table[3][2]=0;
		table[3][3]=40;
		table[3][4]=40;
		table[3][5]=10;
		table[3][6]=10;
		table[3][7]=0;
		table[3][8]=0;
		table[3][9]=0;
		
		//noire
		table[4][0]=0;
		table[4][1]=0;
		table[4][2]=0;
		table[4][3]=40;
		table[4][4]=30;
		table[4][5]=10;
		table[4][6]=20;
		table[4][7]=0;
		table[4][8]=0;
		table[4][9]=0;
		
		//noire pointée
		table[5][0]=0;
		table[5][1]=0;
		table[5][2]=0;
		table[5][3]=50;
		table[5][4]=50;
		table[5][5]=0;
		table[5][6]=0;
		table[5][7]=0;
		table[5][8]=0;
		table[5][9]=0;
		
		//blanche
		table[6][0]=0;
		table[6][1]=0;
		table[6][2]=0;
		table[6][3]=50;
		table[6][4]=50;
		table[6][5]=0;
		table[6][6]=0;
		table[6][7]=0;
		table[6][8]=0;
		table[6][9]=0;
		
		//blanche pointée
		table[7][0]=5;
		table[7][1]=5;
		table[7][2]=0;
		table[7][3]=26;
		table[7][4]=30;
		table[7][5]=20;
		table[7][6]=5;
		table[7][7]=5;
		table[7][8]=2;
		table[7][9]=2;
		
		//ronde
		table[8][0]=10;
		table[8][1]=20;
		table[8][2]=0;
		table[8][3]=20;
		table[8][4]=30;
		table[8][5]=8;
		table[8][6]=6;
		table[8][7]=2;
		table[8][8]=2;
		table[8][9]=2;
		
		//ronde pointée
		table[9][0]=10;
		table[9][1]=20;
		table[9][2]=0;
		table[9][3]=20;
		table[9][4]=30;
		table[9][5]=8;
		table[9][6]=6;
		table[9][7]=2;
		table[9][8]=2;
		table[9][9]=2;


	}

	public int getProba(int i, int j)
	{
		return table[i][j];
	}
}
