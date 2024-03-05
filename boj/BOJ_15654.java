package boj;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_15654
{
    public static int m;
    public static int n;

    public static int[] numList;
    public static ArrayList < Integer > num = new ArrayList <> ();
    public static void main (String[]args) throws IOException
    {
        BufferedReader br =
                new BufferedReader (new InputStreamReader (System.in));
        StringTokenizer st = new StringTokenizer (br.readLine ());
        m = Integer.parseInt (st.nextToken ());
        n = Integer.parseInt (st.nextToken ());
        numList = new int[m];

        StringTokenizer stReadList = new StringTokenizer (br.readLine ());
        for (int i = 0; i < m; i++)
        {
            numList[i] = Integer.parseInt (stReadList.nextToken ());
        }
        Arrays.sort (numList);

        dfs ();



    }

    public static void dfs ()
    {
        if (num.size () == n)
        {
            for (Integer in:num)
            {
                System.out.print (in + " ");
            }
            System.out.println ();
            return;
        }
        for (int i = 0; i < m; i++)
        {
            int now = numList[i];
            if (!num.contains (Integer.valueOf (now)))
            {
                num.add (now);
                dfs ();
                num.remove (num.size () - 1);
            }
        }

    }
}
