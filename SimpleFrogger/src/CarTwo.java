import java.awt.Image;
import javax.swing.Icon;
import javax.swing.JLabel;

/**
 * 
 * This class creates a car of type JLabel.
 *
 */
public class CarTwo extends JLabel{
	Image car;
	private int x = 900;
	final private int Y = 100;
	final public int WIDTH = 189;
	private float speed = (float)(0.10)*WIDTH;
/**
 * Calls superclass constructor to initialize Car.
 * @param i is the picture of the car.
 */
	public CarTwo(Icon i){
		super(i);
	}
	public void addImage(Image i) {
		car = i;
	}
	public Image getImage() {
		return car;
	}
	/**
	 * @param alignmentX increments the position of the car on the x-axis.
	 */
	public void setAlignmentX(float alignmentX){
		if(x > 900) x =-200;
		else{
			x = (int)(x + alignmentX);
		}
	}
	/**
	 * @return the x-value of the position of the car.
	 */
	public float getAlignmentX(){
		return x;
	}
	/**
	 * @return the y-value of the position of the car.
	 */
	public float getAlignmentY(){
		return Y;
	}
	/**
	 * 
	 * @return float value of the cars speed.
	 */
	public float getSpeed(){
		return speed;
	}
	/**
	 * Increases speed in increments of 15.
	 */
	public void increaseSpeed(){
		speed = speed + 5;
	}
	/**
	 * Resets Car's speed back to Level 1 when frog gets hit.
	 */
	public void resetSpeed(){
		speed = (float)(0.1)*WIDTH;
	}
}