import java.awt.Image;
import javax.swing.Icon;
import javax.swing.JLabel;
/**
 * 
 * This class creates a Frog of type Jlabel.
 *
 */
public class Frog extends JLabel{
	Image frog;
	final public int WIDTH = 150;
	final public int HEIGHT = 150;
	private int x = GUI.FRAME_WIDTH/2;
	private int y = GUI.FRAME_HEIGHT - HEIGHT;
	private int count = 1;
	/**
	 * 	calls superclass constructor to initialize Frog.
	 * @param i is a picture of the frog
	 */
	public Frog(Icon i){
		super(i);
	}
	public void addImage(Image i) {
		frog = i;
	}
	public Image getImage() {
		return frog;
	}
	/**
	 * Changes the position of the frog on the y axis.
	 * @param alignmentY is the amount that the y value will be adjusted.
	 */
	public void setAlignmentY(float alignmentY){
		if(alignmentY >0){
			if (y>0) y = (int)(y - alignmentY);
			else win();
		}
		else if(alignmentY<0){
			if(y<GUI.FRAME_HEIGHT - HEIGHT)y = (int)(y - alignmentY);
			else y = GUI.FRAME_HEIGHT - HEIGHT;
		}
		else y=0;
	}
	/**
	 * @return the position of the frog on the y-axis.
	 */
	public float getAlignmentY(){
		return y;
	}
	/**
	 * sets the new position for the frog on the x axis.
	 * @param alignmentX is the amount the x-value will be incremented by.
	 */
	public void setAlignmentX(float alignmentX){
		if(alignmentX >0){
			if (x<750) x = (int)(x + alignmentX);
			else x=750;
		}
		else if(alignmentX<0){
			if(x>150)x = (int)(x + alignmentX);
			else x = 0;
		}
		else x=0;
	}
	/**
	 * @return float value of the position of the frog on x-axis.
	 */
	public float getAlignmentX(){
		return x;
	}
	/**
	 * When the frog gets hit. It goes back to original position.
	 * The level count goes back to 1.
	 */
	public void wasHit(){
		x = GUI.FRAME_WIDTH/2;
		y = GUI.FRAME_HEIGHT - HEIGHT;
		count = 1;
	}
	/**
	 * When the user wins. The frog goes back to it's original position.
	 * Level count goes up.
	 */
	public void win(){
		y = GUI.FRAME_HEIGHT - HEIGHT;
		x = GUI.FRAME_WIDTH/2;
		count = count + 1;
		System.out.println("Level " + count);

	}

}
