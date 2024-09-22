import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;


public class BOJ_2638
{

  public static int n, m;

  public static int[][] map;
  public static int[][] isVisited;
  public static int time = 0;
  public static boolean isMelted;

  public static int[] dx = { 1, -1, 0, 0 };
  public static int[] dy = { 0, 0, 1, -1 };

  public static void main (String[]args) throws IOException
  {
	BufferedReader br =
	  new BufferedReader (new InputStreamReader (System.in));
	StringTokenizer st = new StringTokenizer (br.readLine ());
	  n = Integer.parseInt (st.nextToken ());
	  m = Integer.parseInt (st.nextToken ());

	  map = new int[n][m];
	  isVisited = new int[n][m];

	for (int i = 0; i < n; i++)
	  {
		StringTokenizer stRead = new StringTokenizer (br.readLine ());
		for (int j = 0; j < m; j++)
		  {
			map[i][j] = Integer.parseInt (stRead.nextToken ());
		  }
	  }

	while (!isMelted)
	  {
		solve ();
	  }

	System.out.print (time);
  }

  public static class Node
  {
	public int x;
	public int y;
	  Node (int x, int y)
	{
	  this.x = x;
	  this.y = y;

	}
  }

  public static void solve ()
  {
	time += 1;

	// isVisited initialize
	for (int i = 0; i < n; i++)
	  {
		for (int j = 0; j < m; j++)
		  {
			if (map[i][j] == 1)
			  {
				isVisited[i][j] = 0;
			  }
			else
			  {
				isVisited[i][j] = -1;
			  }
		  }
	  }
	Queue < Node > q = new LinkedList <> ();
	q.add (new Node (0, 0));


	while (!q.isEmpty ())
	  {
		Node node = q.poll ();

		for (int i = 0; i < 4; i++)
		  {
			int nx = node.x + dx[i];
			int ny = node.y + dy[i];

			if (0 <= nx && nx < m && 0 <= ny && ny < n
				&& isVisited[ny][nx] > -2)
			  {
				if (map[ny][nx] == 1)
				  {
					isVisited[ny][nx] += 1;
				  }
				if (map[ny][nx] == 0)
				  {
					isVisited[ny][nx] -= 1;
					q.add (new Node (nx, ny));
				  }
			  }
		  }
	  }
	isMelted = true;
	for (int i = 0; i < n; i++)
	  {

		for (int j = 0; j < m; j++)
		  {
			if (isVisited[i][j] >= 2)
			  {
				map[i][j] = 0;
			  }
			if (map[i][j] == 1)
			  {
				isMelted = false;
			  }
		  }
	  }
  }
}
