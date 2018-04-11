//Vector2D:Utilizado para crear el vector de posición y velcodidad

public class Vector2D {
   private double x, y;  // we will use cartesian coordinates
   public Vector2D () {
	   x = y = 0;
   }
   
   public Vector2D (double x, double y) {
	   this.x=x;
	   this.y=y;
   }
   
   public double getX(){
	   return x;
   }
   
   public double getY(){
	   return y;
   }
   
   public double getA(){//angulo 
	   return Math.atan2(y, x);
   }
   
   public void setTo(double x, double y){
	   this.x=x;
	   this.x=y;
   }
   public Vector2D plus(Vector2D v) {
	   if (v==null) return  new Vector2D(x,y);
	   return new Vector2D(x+v.getX(),y+v.getY());
   }
   public Vector2D times(double scalar) {
	   return  new Vector2D(x*scalar,y*scalar);
   }
   
   public void plusAngle(double dA) { //similar a coordenadas
	   double A = this.getA()+dA; //angulo
	   double r=Math.sqrt(Math.pow(this.x, 2) +Math.pow(this.y, 2));//magnitud 
	   this.setTo(r*Math.cos(A),r*Math.sin(A));
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
   
