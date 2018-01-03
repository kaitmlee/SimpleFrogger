import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 * 
 * This class creates a FroggerComponent of type JComponent.
 *
 */
public class FroggerComponent extends JComponent{
	private Background1 background;
	private Car whitecar;
	private CarTwo redcar;
	private Frog frogger;
/**
 * Initializes FroggerComponent.
 * Adds JLabels
 * Adds KeyListener to the frog and tracks buttons pressed to move the frog.
 */
	public FroggerComponent(){
		background = new Background1(new ImageIcon("road.png"));
		background.addImage(getPic("road.png"));
		frogger = new Frog(new ImageIcon("frog.png"));
		frogger.addImage(getPic("frog.png"));
		whitecar = new Car(new ImageIcon("whitecar.png"));
		whitecar.addImage(getPic("whitecar.png"));
		redcar = new CarTwo(new ImageIcon("redcar.png"));
		redcar.addImage(getPic("redcar.png"));
		frogger.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent e){}
			public void keyReleased(KeyEvent e){
				int key = e.getKeyCode();
				if(key == KeyEvent.VK_UP){
					frogger.setAlignmentY(150);
				}
				if(key == KeyEvent.VK_DOWN){
					frogger.setAlignmentY(-150);
				}
				if(key == KeyEvent.VK_LEFT){
					frogger.setAlignmentX(-150);
				}
				if(key == KeyEvent.VK_RIGHT){
					frogger.setAlignmentX(150);
				}
			}
			public void keyTyped(KeyEvent e){}
		});
		frogger.setFocusable(true);
		frogger.requestFocus();
		add(background);
		add(frogger);
		add(whitecar);
		add(redcar);


	}
	/**
	 * Sets the cars new alignment.
	 * Paints the new component after the JLabels and their new positions are updated.
	 * calls method to check if Frog is at top or if their was a collision.
	 */
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		whitecar.setAlignmentX(whitecar.getSpeed());
		redcar.setAlignmentX(redcar.getSpeed());
		g2.drawImage(background.getImage(), (int)background.getAlignmentX(), (int)background.getAlignmentY(), null);
		g2.drawImage(frogger.getImage(), (int)frogger.getAlignmentX(), (int)frogger.getAlignmentY(), null);
		g2.drawImage(whitecar.getImage(), (int)whitecar.getAlignmentX(), (int)whitecar.getAlignmentY() , null);
		g2.drawImage(redcar.getImage(), (int)redcar.getAlignmentX(), (int)redcar.getAlignmentY() , null);
		atTop();
		isCollision();
	}
	/**
	 * Checks to see if Frog is at the top(win)
	 * If it is then a method is called to increase the car's speed
	 * then another is called to reset the frog variables.
	 */
	public void atTop(){
		if(frogger.getAlignmentY() ==0){
			whitecar.increaseSpeed();
			frogger.win();
		}
	}
	/**
	 * Checks to see if there was a collision.
	 * If the frogs left or right edge is in between the cars edges.
	 * If there was then a method is called to reset the cars speed,
	 * and another to reset the frog variables.
	 */
	public void isCollision(){
		double frogRightedge = frogger.getAlignmentX() + (frogger.WIDTH)/2;
		double frogLeftedge = frogger.getAlignmentX() - (frogger.WIDTH)/2;
		double carLeftedge = whitecar.getAlignmentX() - (whitecar.WIDTH/2);
		double carRightedge = whitecar.getAlignmentX() + (whitecar.WIDTH/2);
		if(frogger.getAlignmentY() == whitecar.getAlignmentY()){
			if(frogLeftedge > carLeftedge && frogLeftedge < carRightedge){
				whitecar.resetSpeed();
				System.out.println("Try again");
				frogger.wasHit();
			}
			if(frogRightedge > carLeftedge && frogRightedge < carRightedge){
				whitecar.resetSpeed();
				System.out.println("Try again");
				frogger.wasHit();
			}
		}
	}
	/**
	 * Creates an Image from a png.
	 * @return Image
	 */
	public Image getPic(String png){
		BufferedImage image = null;
		try { 
			image = ImageIO.read(new File(png)); 
		} 
		catch (IOException e) { 
			System.out.println("No Image of " + png);
		}
		return Toolkit.getDefaultToolkit().createImage(image.getSource());
	}
}
