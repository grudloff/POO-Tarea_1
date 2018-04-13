public class Stage1 {
   public static void main(String[] args) {

      double deltaTime = 0.1;    // [s]
      MyWorld world = new MyWorld(System.out);
      
      Vector2D position = new Vector2D(0,0);  // [m] 
      Vector2D velocity = new Vector2D(0.5,0.0);     // [m/s]
      Robot r = new Robot(position, velocity);
      world.setRobot(r);
      world.printStateDescription();
      world.simulate(deltaTime, 0.5); // delta time[s], total simulation time [s].
      r.turnLeft();
      world.simulate(deltaTime, 1); // delta time[s], total simulation time [s].
      r.turnRight();
      world.simulate(deltaTime, 1.5); // delta time[s], total simulation time [s].
      r.turnRight();
      world.simulate(deltaTime, 2); // delta time[s], total simulation time [s].
   }
}
