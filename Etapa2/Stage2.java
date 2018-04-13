import java.io.*;
import java.util.*;

public class Stage2 {
   public static void main(String[] args) throws IOException  {
      if(args.length !=2){
         System.out.println("Usage: java Stage2 <pbm input file> <pbm output file>");
         System.exit(0);
      }
      Scanner in = new Scanner(new File(args[0]));
      PrintStream out = new PrintStream(new File(args[1]));

      Maze maze = new Maze(in);
      maze.rotate();
      maze.write(out);
   }
}
