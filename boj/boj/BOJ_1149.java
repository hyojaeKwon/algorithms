import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class BOJ_1149
{
  public static int[][][] map;
  public static void main (String[]args) throws IOException
  {
	BufferedReader br =
	  new BufferedReader (new InputStreamReader (System.in));
	StringTokenizer st = new StringTokenizer (br.readLine ());
	int n = Integer.parseInt (st.nextToken ());

	  map = new int[2][n][3];

	for (int i = 0; i < n; i++)
	  {
		StringTokenizer stRead = new StringTokenizer (br.readLine ());
		for (int j = 0; j < 3; j++)
		  {
			int color = Integer.parseInt (stRead.nextToken ());
			  map[0][i][j] = color;
		  }
	  }

	for (int i = 0; i < 3; i++)
	  {
		map[1][0][i] = map[0][0][i];
	  }
	for (int i = 1; i < n; i++)
	  {
		for (int j = 0; j < 3; j++)
		  {
			if (j == 0)
			  {
				map[1][i][j] =
				  Math.min (map[1][i - 1][1],
							map[1][i - 1][2]) + map[0][i][j];
			  }
			else if (j == 1)
			  {
				map[1][i][j] =
				  Math.min (map[1][i - 1][0],
							map[1][i - 1][2]) + map[0][i][j];
			  }
			else
			  {
				map[1][i][j] =
				  Math.min (map[1][i - 1][1],
							map[1][i - 1][0]) + map[0][i][j];
			  }
		  }
	  }
	System.out.println (Math.min
						(Math.min (map[1][n - 1][0], map[1][n - 1][1]),
						 map[1][n - 1][2]));

  }
}
