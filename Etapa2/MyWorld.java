import java.io.*;

public class MyWorld {
	private double t0=0;
   public MyWorld(){
      this(System.out);  
   }
   public MyWorld(PrintStream output){
    out=output;
   }

   public void setRobot(Robot r) {
	   this.r=r;	
   }
   public void printStateDescription(){
	   out.println("Time" + ",\t" + r.getDescription());
   }

   private void printState(double t){
	   out.println(t + ",\t" + r.toString());
   }

   public void simulate (double delta_t, double endTime) {  // simulate time passing by
	   	for (double t=t0 ; t < endTime; t += delta_t) {
	   		r.moveDelta_t(delta_t);
	   		printState(t);
	   		t0=t;
	   	}
   }

   private Robot r;
   private PrintStream out;
}