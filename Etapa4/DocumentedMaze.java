import java.util.*;
class DocumentedMaze extends Maze {//inherited class to extend Maze and include entrance and exit points.
   public DocumentedMaze(Scanner sc) {
	   super();
     // Skip first line of file (P1)
	   sc.nextLine();
	// skip # simbol of the second line
	   sc.findInLine("#");
     // read entrace, direction, exit point, and radius
	   //Hay un cero al principio por alguna razon

	   entrance = new Vector2D(sc.nextInt(),sc.nextInt());
	   dir = new Vector2D(sc.nextInt(), sc.nextInt());
	   exit = new Vector2D(sc.nextInt(),sc.nextInt());
	   exitRadius=sc.nextInt();
     // ask the super class to read the rest of the file
	   read(sc);
   }
   public void setEntrance(int x, int y){
      entrance.setTo(x,y);
   }
   public void setDirection(int x, int y){
      dir.setTo(x,y);
   }
   public void setExit(int x, int y){
      exit.setTo(x,y);
   }
   public void setExitRadius(int r){
      exitRadius = r;
   }
   public Vector2D getEntrance() {
      return entrance;
   }
   public Vector2D getDirection() {
      return dir;
   }
   public Vector2D getExit() {
      return exit;
   }
   public double getExitRadius() {
      return exitRadius;
   }
   private Vector2D entrance, dir, exit;
   private double exitRadius;
}