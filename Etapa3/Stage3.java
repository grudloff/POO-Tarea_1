import java.io.*;
import java.util.*;

public class Stage3 {
   public static void main(String[] args) throws IOException  {
      if(args.length !=2){
         System.out.println("Usage: java Stage3 <pbm input file> <pbm output file>");
         System.exit(0);
      }
      Scanner in = new Scanner(new File(args[0]));
      PrintStream out = new PrintStream(new File(args[1]));

      Maze maze = new Maze(in);
      Maze route = new Maze(maze); 

      double deltaTime = 1.0;    // [s]
      MyWorld world = new MyWorld();
      
      world.setMaze(maze);
      Vector2D position = new Vector2D(10,20);  //Col ln 15 5 [m] 
      Vector2D velocity = new Vector2D(0.0,1.0);     // [m/s]
      double sensorRange = 3;
      Robot r = new Robot(position, velocity, sensorRange, world);
      world.setRobot(r);
      world.printStateDescription();
      world.simulate(deltaTime, 120, route); // delta time[s], total simulation time [s].
      route.write(out);
   }
}
