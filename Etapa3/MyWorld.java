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
   public void setMaze(Maze m) {
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
     String s = t + ",\t" + r;
     out.println(s);    
   }

   public void simulate (double delta_t, double endTime, Maze route) {  // simulate time passing by
     for (; t < endTime; t += delta_t) {
         r.moveDelta_t(delta_t);
         printState(t);
         r.markRoute(route);
      }
   }

   private Robot r;
   private Maze maze;
   private double t;
   private PrintStream out;
}