import java.io.IOException;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main
{

  public static int n, m, x;

  public static int[][] map;
  public static boolean[] visit;
  public static void main (String[]args) throws IOException
  {

	BufferedReader br =
	  new BufferedReader (new InputStreamReader (System.in));

	StringTokenizer st = new StringTokenizer (br.readLine ());
	  n = Integer.parseInt (st.nextToken ());
	  m = Integer.parseInt (st.nextToken ());
	  x = Integer.parseInt (st.nextToken ());
	  x = x - 1;				// starts from 0


	  map = new int[n][n];
	  visit = new boolean[n];

	// initialize
	for (int i = 0; i < n; i++)
	  {
		for (int j = 0; j < n; j++)
		  {
			map[i][j] = 30000000;

		  }
		visit[i] = false;
	  }

	// input distance 
	for (int i = 0; i < m; i++)
	  {
		StringTokenizer stRead = new StringTokenizer (br.readLine ());
		int nRead = Integer.parseInt (stRead.nextToken ());
		int mRead = Integer.parseInt (stRead.nextToken ());
		int xRead = Integer.parseInt (stRead.nextToken ());

		map[nRead - 1][mRead - 1] = xRead;
	  }


	for (int i = 0; i < n; i++)
	  {
		djikstra (i);
		clearToFalseVisit ();
	  }


	Integer[] totalDis = new Integer[n];
	for (int i = 0; i < n; i++)
	  {
		Integer dis = map[i][x] + map[x][i];
		totalDis[i] = dis;
	  }
	  
	Arrays.sort (totalDis, new Comparator < Integer > ()
				 {
				 @Override public int compare (Integer o1, Integer o2)
				 {
				 return o2.compareTo (o1);}
				 }
	);
	System.out.println (totalDis[0]);
  }



  // clear visit
  public static void clearToFalseVisit ()
  {
	for (int i = 0; i < n; i++)
	  {
		visit[i] = false;
	  }
  }

  public static void djikstra (int start)
  {
	map[start][start] = 0;
	visit[start] = true;
	for (int i = 0; i < n - 1; i++)
	  {
		int minNode = getMinNode (start);
		visit[minNode] = true;
		for (int j = 0; j < n; j++)
		  {
			if (map[minNode][j] != 0
				&& (map[minNode][j] + map[start][minNode]) < map[start][j])
			  {
				map[start][j] = map[minNode][j] + map[start][minNode];
			  }
		  }
	  }

  }


  public static int getMinNode (int start)
  {
	int min = 30000000;
	int node = 0;
	for (int i = 0; i < n; i++)
	  {
		if (map[start][i] < min && visit[i] == false)
		  {
			min = map[start][i];
			node = i;
		  }
	  }

	return node;
  }

}
