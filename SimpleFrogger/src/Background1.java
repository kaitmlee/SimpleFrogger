import java.awt.Image;
import javax.swing.Icon;
import javax.swing.JLabel;

public class Background1 extends JLabel{
	Image back;
	private int x = 0;
	private int y = 0;
	/**
	 * 	calls superclass constructor to initialize Frog.
	 * @param i is a picture of the frog
	 */
	public Background1(Icon i){
		super(i);
	}
	public void addImage(Image i) {
		back = i;
	}
	public Image getImage() {
		return back;
	}
	public float getAlignmentY(){
		return y;
	}
	public float getAlignmentX(){
		return x;
	}
}
