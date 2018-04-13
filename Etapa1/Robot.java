

public class Robot {
	public final double A=3.1415/2.0;
	public Robot() { 
		this(new Vector2D(), new Vector2D());
	}
	public Robot(Vector2D position, Vector2D velocity) {
		pos=position;
		v=velocity;
	}
	public Vector2D getPosition() {
		return pos;
	}
	public void turnLeft(){
		v.plusAngle(A);
	}
	public void turnRight(){
		v.plusAngle(-A);
	}
	public void moveDelta_t(double delta_t) {
		pos=pos.plus(v.times(delta_t));
	}
	public String getDescription() {
		return pos.getDescription();
	}
	public String toString() {
		return pos.toString();
	}
	private Vector2D pos;
	private Vector2D v;
}