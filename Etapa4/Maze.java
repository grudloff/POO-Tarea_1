import java.io.*;
import java.util.*;

public class Maze {
	public Maze() {
	   }
	public Maze(Scanner sc) {
	      read(sc);
	   }
	public Maze (Maze m){  // This is called copy constructor
		   array = new boolean [m.array.length][];
		   for (int h = 0; h < m.array.length; h++) {
			   array[h] = new boolean [m.array[0].length];
		        System.arraycopy(m.array[h], 0, array[h], 0, m.array[0].length);
		    }
	   }
   public void read(Scanner sc){
	   String s;
	      while(!sc.hasNextInt())
	          sc.nextLine();
	      int width = sc.nextInt();
	      int hight = sc.nextInt();
	      sc.nextLine();
	      array = new boolean [hight][];
	      for (int h=0; h<hight; h++)
	         array[h] = new boolean[width];
	      for (int h=0; h<hight; h++) 
	         for (int w=0; w<width; ){
	            s = sc.findInLine(".");
	            if (s==null) sc.nextLine();
	            else array[h][w++] = s.charAt(0)=='1';  
	         }
   }

   public boolean isThere_a_wall(int x, int y) {
	   if(!(0<x&&x<array.length)||!(0<y&&y<array[0].length))
		   return true;
	   else
		   return array[x][y];     
   }
   public void markPoint(Vector2D p){
     array[(int)p.getX()][(int)p.getY()]=true;
     return;
   }
   public void write(PrintStream out){
      out.println("P1");
      out.println("#Created by "+getClass().getName()+"UTFSM ELO329");
      out.println(array[0].length + " " +array.length);
      for (int h=0; h<array.length; h++) {
         for (int w=0; w<array[0].length; w++)
            out.print(array[h][w]?"1":"0");
         out.println();
      }   
   }
   private boolean [][] array;
}

