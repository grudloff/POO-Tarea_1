import java.io.*;
import java.util.*;

public class Stage5 {
   public static void main(String[] args) throws IOException  {
	  Scanner in;
	  PrintStream out1;
	  PrintStream out2;
      if(args.length < 2 ){
         System.out.println("Usage: java Stage4 <pbm input file> <pbm output file> [ix iy  dx  dy  fx  fy  r]");
         //System.exit(0);
         //Modificación para debugeo
         in = new Scanner(new File("d_maze_in.pbm"));
         out1 = new PrintStream(new File("maze_out_1.pbm"));
         out2 = new PrintStream(new File("maze_out_2.pbm"));


      }
      else {
    	  StringBuffer out_filename1= new StringBuffer(args[1]);
    	  out_filename1.insert(out_filename1.length()-4,"_1");
    	  StringBuffer out_filename2= new StringBuffer(args[1]);
    	  out_filename2.insert(out_filename1.length()-4,"_2");
    	  in = new Scanner(new File(args[0]));
    	  out1 = new PrintStream(new File(out_filename1.toString()));
    	  out2 = new PrintStream(new File(out_filename2.toString()));
      }

      DocumentedMaze maze = new DocumentedMaze(in);
      Maze route1 = new Maze(maze); 
      Maze route2 = new Maze(maze); 
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
      Robot r1 = new Robot(position, velocity, sensorRange, world,false);
      Robot r2 = new Robot(position, velocity, sensorRange, world,true);
      world.setRobot(r1,r2);
      //world.printStateDescription();	//Esto sirve solo para debuggear
      world.simulate(deltaTime, route1,route2); // delta time[s], total simulation time [s].
      route1.write(out1);
      route2.write(out2);
   }
}
