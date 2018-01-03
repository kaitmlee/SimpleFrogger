import javax.swing.JFrame;

/**
 * 
 * This class is the GUI 
 *
 */
public class GUI{
	   public static final int FRAME_WIDTH = 945;
	   public static final int FRAME_HEIGHT = 600;
/**
 * Main creates a new Jframe and adds a FroggerComponent to it	   
 * @param args
 */
	public static void main(String[] args)
	{
		 JFrame frame = new JFrame();
		 FroggerComponent frogger = new FroggerComponent();
		 frame.add(frogger);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setVisible(true);
		 frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);

	      while (true)
	      {
	        try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        frogger.repaint();
	      }
	}
}
