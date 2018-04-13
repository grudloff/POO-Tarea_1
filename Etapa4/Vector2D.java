public class Vector2D {
   private double x, y;  // we will use cartesian coordinates
   public Vector2D () {
	   x = y = 0;
   }
   public Vector2D (double x, double y) {
	   this.x=x;
	   this.y=y;
   }
   public double getModule() {
	   return Math.sqrt(Math.pow(this.getX(),2.0)+Math.pow(this.getY(),2.0));
   }
   public Vector2D getUnitary() {
	   return this.times(1/this.getModule());
   }

   
   public double getX(){
	   return x;
   }
   public double getY(){
	   return y;
   }
   public void turnLeft() {
	   double x_aux=x;
	   x=-y;
	   y=x_aux;
   }
   public void turnRight() {
	   double x_aux=x;
	   x=y;
	   y=-x_aux;
   }
   public void setTo(double x, double y){
	   this.x=x;
	   this.y=y;
   }
   public Vector2D plus(Vector2D v) {
	   if (v==null) return  new Vector2D(x,y);
	   return new Vector2D(x+v.getX(),y+v.getY());
   }
   public Vector2D times(double scalar) {
	   return  new Vector2D(x*scalar,y*scalar);
   }
   public Vector2D minus(Vector2D v) {
	   if (v==null) return  new Vector2D(x,y);
	   else return new Vector2D(x-v.x, y-v.y);
   }
   public String getDescription(){
	   return "x,\ty";
   }
   public String toString(){
	   return x + ",\t" + y;
   }
}
   
