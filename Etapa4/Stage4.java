import java.io.*;
import java.util.*;

public class Stage4 {
   public static void main(String[] args) throws IOException  {
	  Scanner in;
	  PrintStream out;
      if(args.length < 2 ){
         System.out.println("Usage: java Stage4 <pbm input file> <pbm output file> [ix iy  dx  dy  fx  fy  r]");
         //System.exit(0);
         //Modificación para debugeo
         in = new Scanner(new File("d_maze_in.pbm"));
         out = new PrintStream(new File("maze_out.pbm"));

      }
      else {
    	  in = new Scanner(new File(args[0]));
    	  out = new PrintStream(new File(args[1]));
      }

      DocumentedMaze maze = new DocumentedMaze(in);
      Maze route = new Maze(maze); 
      if (args.length > 3) 
         maze.setEntrance(Integer.parseInt(args[2]),Integer.parseInt(args[3]));
      if (args.length > 5)       
         maze.setDirection(Integer.parseInt(args[4]),Integer.parseInt(args[5]));
      if (args.length > 7)               
         maze.setExit(Integer.parseInt(args[6]),Integer.parseInt(args[7]));
      if (args.length > 8)
         maze.setExitRadius(Integer.parseInt(args[8]));
      

      double deltaTime = 1.0;    // [s]
      MyWorld world = new MyWorld();
      
      world.setMaze(maze);
      Vector2D position = maze.getEntrance();  // [m] 
      double speed = 1.0;
      Vector2D velocity = maze.getDirection().getUnitary().times(speed);     // [m/s]
      double sensorRange = 3;
      Robot r = new Robot(position, velocity, sensorRange, world);
      world.setRobot(r);
      //world.printStateDescription();	//Esto sirve solo para debuggear
      world.simulate(deltaTime, route); // delta time[s], total simulation time [s].
      route.write(out);
   }
}
