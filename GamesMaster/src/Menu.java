import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Menu extends JFrame implements ActionListener {
	
	private JMenuItem g1 = new JMenuItem("Maze");
	private JMenuItem g2 = new JMenuItem("Chess");
	private JMenuItem g3 = new JMenuItem("Concentration");
	private JMenuItem i2 = new JMenuItem("Settings");
	private JMenuItem i3 = new JMenuItem("Close");

	public Menu(){
		JFrame F = new JFrame("GAMESMASTER");
		JMenuBar menbar = new JMenuBar();
		JMenuBar mbar = new JMenuBar();
		JMenu menu1 = new JMenu ("Games");
		JMenu menu2 = new JMenu ("Settings");
		JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();
		JLabel text = new JLabel("BIRDSTUFZ - GAMESMASTER PROTO");
		JLabel text2 = new JLabel("BIRDSTUFZ - GAMESMASTER PROTO");
		//JMenu menu3 = new JMenu ("");
		
		ImageIcon image = new ImageIcon(getClass().getResource("p1.png"));
		JLabel button = new JLabel(image);
		ImageIcon image2 = new ImageIcon(getClass().getResource("p2.png"));
		JLabel button2 = new JLabel(image2);
		ImageIcon image3 = new ImageIcon(getClass().getResource("p3.png"));
		JLabel button3 = new JLabel(image3);
		button.setSize(50,50);
		button2.setSize(50,50);
		button3.setSize(50,50);

		button.addMouseListener(new MouseAdapter() {
		  @Override
		  public void mouseClicked(MouseEvent e) {
			  MazeGame.build();
			  F.dispose();
		  }
		});
		
		button2.addMouseListener(new MouseAdapter() {
			  @Override
			  public void mouseClicked(MouseEvent e) {
			     Game.build();
			     F.dispose();
			  }
		});
		button3.addMouseListener(new MouseAdapter() {
			  @Override
			  public void mouseClicked(MouseEvent e) {
			    // new ChessBoardWithColumnsAndRows().build() ;
				 new ChessGUI().build();
			     F.dispose();
			  }
		});
		
		
		text.setHorizontalAlignment(SwingConstants.LEFT);
		text.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		text2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		pan2.add(text2);
		
		g1.addActionListener(this);
		g2.addActionListener(this);
		g3.addActionListener(this);
		i3.addActionListener(this);
		menu1.add(g1);
		menu1.add(g2);
		menu1.add(g3);
		menu2.add(i2);
		menu1.add(i3);
		
		menbar.add(menu1);
		menbar.add(menu2);
		
		BufferedImage myPicture;
		Image newImage;
		try {
			newImage = ImageIO.read(new File("res/icon2.png"));
			newImage.getScaledInstance(1, 1, Image.SCALE_DEFAULT);
			JLabel picLabel = new JLabel(new ImageIcon(newImage));
			//picLabel.setBounds(-100,-50,1,1);
			pan1.add(picLabel);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		pan1.add(text);
		
		try {
			newImage = ImageIO.read(new File("res/icon2.png"));
			newImage.getScaledInstance(1, 1, Image.SCALE_DEFAULT);
			JLabel picLabel = new JLabel(new ImageIcon(newImage));
			//picLabel.setBounds(-100,-50,1,1);
			pan1.add(picLabel);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
		    F.setIconImage(ImageIO.read(new File("res/icon.png")));
		}
		catch (IOException exc) {
		    exc.printStackTrace();
		}
		
		F.setJMenuBar(menbar);
		F.setLayout(new BorderLayout());
		F.add(pan2,BorderLayout.NORTH);
		F.add(pan1,BorderLayout.SOUTH);
		F.add(button,BorderLayout.WEST);
		F.add(button2,BorderLayout.EAST);
		F.add(button3, BorderLayout.CENTER);
		F.setSize(700,700);
		F.getContentPane().setBackground(Color.GRAY);
		F.setVisible(true);
		
		}
	
	public static void main(String[]args){
		new Menu();
	}
	
	/** Returns an ImageIcon, or null if the path was invalid. */
	protected ImageIcon createImageIcon(String path,
	                                           String description) {
	    java.net.URL imgURL = getClass().getResource(path);
	    if (imgURL != null) {
	        return new ImageIcon(imgURL, description);
	    } else {
	        System.err.println("Couldn't find file: " + path);
	        return null;
	    }
	}
	
	@Override
	public void actionPerformed(ActionEvent E) {
		// TODO Auto-generated method stub
		if(E.getSource() == g1){
			MazeGame.build();
			//Menu.getFrame().dispose();
		}
		else if(E.getSource() == g2){
			ChessGUI f = new ChessGUI();
			f.build();
			//Menu.getFrame().dispose();
		}
		else if(E.getSource() == g3){
			Game.build();
		}
		else if(E.getSource()== i2) {
			System.exit(0);
		}
		else if(E.getSource()== i3) {
			System.exit(0);
		}
	}

}