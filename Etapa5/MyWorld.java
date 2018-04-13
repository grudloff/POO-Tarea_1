import java.io.*;

public class MyWorld {
   public MyWorld(){
      this(System.out);  
   }
   public MyWorld(PrintStream output){
      out = output;
      r1 = null;
      r2 = null;
      t = 0;   
   }

   public void setRobot(Robot r1,Robot r2) {
      this.r1 = r1;
      this.r2 = r2;
   }
   public void setMaze(DocumentedMaze m) {
      maze = m;
   }
   public boolean isThere_a_wall(int x, int y){
      return maze.isThere_a_wall(x,y);
   }
   
   public void printStateDescription(){
     String s = "Time" + ",\t" + r1.getDescription();
     out.println(s);
   }

   private void printState(double t,boolean u){
	   String s;
	   if(u)
		   s = t + ",\t" + r1.toString() ;
	   else
		   s = t + ",\t" + r2.toString();
	   out.println(s);    
   }

   public void simulate (double delta_t, Maze route1,Maze route2) {  // simulate time passing by
     while (!((r1.getPosition().minus(maze.getExit())).getModule()<maze.getExitRadius())) {
         printState(t,true);  // for debugging pourpuse
         r1.markRoute(route1);
         r1.moveDelta_t(delta_t);
         t+=delta_t;
     }
     double t_max=t;
     t=0;
     while (!((r2.getPosition().minus(maze.getExit())).getModule()<maze.getExitRadius())||t>t_max) {
         printState(t,false);  // for debugging pourpuse
         r2.markRoute(route2);
         r2.moveDelta_t(delta_t);
         t+=delta_t;
     }
   }


   private Robot r1,r2;
   private DocumentedMaze maze;
   private double t;
   private PrintStream out;
}