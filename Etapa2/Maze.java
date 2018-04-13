import java.io.*;
import java.util.*;

public class Maze {
   public Maze(Scanner sc) {
      String s;
      while(!sc.hasNextInt())
          sc.nextLine();
      width = sc.nextInt();
      hight = sc.nextInt();
      sc.nextLine();
      array = new boolean [hight][];
//      for (int h=0; h<hight; h++)
//         array[h] = new boolean[width];
      for (int h=0; h<hight; h++) { 
    	 array[h] = new boolean[width];
         for (int w=0; w<width; ){
            s = sc.findInLine(".");
            if (s==null) sc.nextLine();
            else array[h][w++] = s.charAt(0)=='1';  
         }
      }
   }
   public void rotate() {
	   boolean [][] array_aux = new boolean[width][];
	   for (int w=0; w<width; w++) {
	         array_aux[w] = new boolean[hight];
	         for(int h=0;h<hight;h++)
	        	 array_aux[w][h]=array[h][width-1-w];
	   }
	   int hight_aux=hight;
	   hight=width;
	   width=hight_aux;
	   array=array_aux;
   }
   public void write(PrintStream out){
	  out.println("P1");
	  out.println("#Created by "+getClass().getName()+"UTFSM ELO329");
	  out.println(width +" "+hight);
	  for(int h=0;h<hight;h++) {
		  for (int w=0; w<width; w++) {
			  if(array[h][w])
    			  out.print("1");
    		  else
    			  out.print("0");
			  }      
	  }
   }
   private boolean [][] array;
   private int hight;
   private int width;
   
}