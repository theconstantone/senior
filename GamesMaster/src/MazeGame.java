import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
public class MazeGame extends JFrame {
	int sx = 20;
	int sy = 20;
	int cellSize = 20;
	
	MazeM m1 = new MazeM(sx,sy);
	
	public MazeGame() {
		initUI();
	}
	
	public static void build() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				MazeGame nz = new MazeGame();
				nz.setVisible(true);
			}
	
		});
	}
	
	public void initUI() {
		
		setTitle("MAZE MASTER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(sx * cellSize + 200, sy * cellSize + 75);
		
		MazeDisplay md = new MazeDisplay(m1,cellSize);
		
		add(md);
		addKeyListener(md);
		setContentPane(md);
		md.setFocusable(true);
		
		setLocationRelativeTo(null);
	}
}
