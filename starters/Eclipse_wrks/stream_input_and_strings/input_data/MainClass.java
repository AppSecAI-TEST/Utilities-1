package input_data;

import java.io.*;
import  java.util.*;

public class MainClass {

  public MainClass() {
  }
  public static void main(String[] args) {
    System.out.print("Enter integer number(s) ->");
    try
    {
// obsolete:
//      DataInputStream dis = new DataInputStream (System.in);
//      String s = dis.readLine();
    	BufferedReader dis =
    		new BufferedReader (new InputStreamReader(System.in));

    	String s = dis.readLine();
// 1)
//      int v = Integer.parseInt(s);
//      System.out.print("You entered  number " + v);
//2)
    	StringTokenizer st = new StringTokenizer(s);
    	while (st.hasMoreTokens())
    	{
    		String str = st.nextToken();
    		int v = Integer.parseInt(str);
    		
    		System.out.println("You entered  number " + v);
    	}    		
    }
    catch (Exception e)
    {
      System.out.println ("Error message: " + e.getMessage());
    }
  }
}