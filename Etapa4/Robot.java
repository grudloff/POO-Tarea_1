public class Robot {
   private Robot() { 
      this(new Vector2D(), new Vector2D(), 0, null);
   }
   public Robot(Vector2D position, Vector2D velocity, double sensorRange, MyWorld w) {
	   pos = position;
	   v = velocity;
	   world = w;
	   Vector2D dir = v.getUnitary();
	   rightSensor = new DistanceSensor(new Vector2D(dir.getY(), -dir.getX()), sensorRange);
	   frontSensor = new DistanceSensor(dir, sensorRange);
	   leftSensor = new DistanceSensor(new Vector2D(-dir.getY(), dir.getX()), sensorRange);
   // similar to Robot in previous stage without the logic to set the course
   /// that ti is now asked to the pilot
      pilot = new Pilot ();
   }


public Vector2D getPosition() {
   return pos;
}
public Vector2D getVelocity() {
   return v;
}
public void turnLeft(){
   v.turnLeft();
   rightSensor.turnLeft();
   frontSensor.turnLeft();
   leftSensor.turnLeft();
   //System.out.println("turning left...");  // for debugging
   return; 
}
public void turnRight(){
   v.turnRight();
   rightSensor.turnRight();
   frontSensor.turnRight();
   leftSensor.turnRight();      
   //System.out.println("turning right...");
   return; 
}
public DistanceSensor getRightSensor() {
	return rightSensor;
}
public DistanceSensor getLeftSensor() {
	return leftSensor;
}
public DistanceSensor getFrontSensor() {
	return frontSensor;
}
public void moveDelta_t(double delta_t) {
	   pilot.setCourse(delta_t);
	   return;
}
public String getDescription() {
   return pos.getDescription() + ",  leftS frontS rightS";
}
public String toString() {
   return pos.toString()+ "," +leftSensor.toString() + frontSensor.toString()+rightSensor.toString()+ ", " +v.toString();
}
public void markRoute(Maze m){
   m.markPoint(pos);
}
//
	public class Pilot {
	   public Pilot(){
	   // set the lookingForRightWall depending on the left sensor state
	     lookingForRightWall=!rightSensor.senseWall();
	   }
	   public void setCourse(double delta_t){
		   if(leftSensor.senseWall()) {
			  turnRight();
			  return;
			  }
		  if(frontSensor.senseWall()) {
			  turnLeft();
			  return;
		  }
		  if(rightSensor.senseWall()) {
			  lookingForRightWall=false;
			  pos = pos.plus(v.times(delta_t));  
			  return;
		  }
		  if(lookingForRightWall) {
			  pos = pos.plus(v.times(delta_t));  
			  return;
		  }
		  turnRight();
		  lookingForRightWall=true;
		  return;   
	   }
	   private boolean lookingForRightWall; //it is used to find the right wall at the beginning
	}

   public class DistanceSensor {  // now public because it is also used my Pilot
	   public DistanceSensor(Vector2D direction, double rang) {
	         dir = direction;
	         range = rang;
	      }
	      public void turnLeft(){
	         dir.turnLeft();
	      }
	      public void turnRight() {
	         dir.turnRight();
	      }
	      public boolean senseWall(){
	    	  Vector2D s = new Vector2D();
	    	  for(float i=0;i<range;i+=presition) {
	    		  s=pos.plus(this.dir.times(i)); 
				  if (world.isThere_a_wall((int)s.getX(),(int)s.getY()))
				  	return true;
	    	  }
	    	  return false;
	      }
	      public String toString() {
	         return " "+senseWall();
	      }
	      
	      private Vector2D dir;  // orientation direction with respect to forward robot's direction
	      private double range;
	      private static final double presition = 0.4;
   }
      
   private Vector2D pos;
   private Vector2D v;
   private MyWorld world;
   private DistanceSensor rightSensor, frontSensor, leftSensor;
   private Pilot pilot;
}