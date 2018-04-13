import java.io.*;

public class MyWorld {
   public MyWorld(){
      this(System.out);  
   }
   public MyWorld(PrintStream output){
      out = output;
      r = null;
      t = 0;   
   }

   public void setRobot(Robot r) {
      this.r = r;
   }
   public void setMaze(DocumentedMaze m) {
      maze = m;
   }
   public boolean isThere_a_wall(int x, int y){
      return maze.isThere_a_wall(x,y);
   }
   
   public void printStateDescription(){
     String s = "Time" + ",\t" + r.getDescription();
     out.println(s);
   }

   private void printState(double t){
     String s = t + ",\t" + r.toString();
     out.println(s);    
   }

   public void simulate (double delta_t, Maze route) {  // simulate time passing by
     while (!((r.getPosition().minus(maze.getExit())).getModule()<maze.getExitRadius())) {
         //printState(t);  // for debugging pourpuse
         r.markRoute(route);
         r.moveDelta_t(delta_t);
         t+=delta_t;
     }
   }


   private Robot r;
   private DocumentedMaze maze;
   private double t;
   private PrintStream out;
}