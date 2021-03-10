import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main{
	
	JFrame frame;
	Color currentColor = Color.BLACK;
	
	int xSize = 10;
	int ySize = 10;
	
	Main(){
		frame = new JFrame();
		
		frame.addMouseMotionListener(new MouseInput());
		frame.setSize(750, 750);
		
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
		
		topPanel.add(new ColorChooserButton(currentColor, this));
		topPanel.add(new JLabel("Size: "));
		
		JTextField xSizeF = new JTextField(2);
		xSizeF.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int newXS = 0;
				try{
					newXS = Integer.parseInt(xSizeF.getText());
					
				}catch(Exception ex){
					ex.printStackTrace();
					return;
				}
				
				xSize = newXS;
			}
			
		});
		
		topPanel.add(xSizeF);
		
		
		JTextField ySizeF = new JTextField(2);
		ySizeF.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int newYS = 0;
				try{
					newYS = Integer.parseInt(ySizeF.getText());
					
				}catch(Exception ex){
					ex.printStackTrace();
					return;
				}
				
				ySize = newYS;
			}
			
		});
		
		topPanel.add(ySizeF);
		
		JButton clearButton = new JButton("Clear");
		
		clearButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Graphics g2 = frame.getGraphics();
				g2.setColor(Color.white);
				g2.fillRect(0, 40, frame.getWidth(), frame.getHeight());
			}
		});
		
		topPanel.add(clearButton);
		
		frame.add(BorderLayout.NORTH, topPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		frame.setVisible(true);
	}
	
	class MouseInput implements MouseMotionListener{ 
		public void mouseDragged(MouseEvent e){
			
			Graphics g = frame.getGraphics();
			g.setColor(currentColor);
			g.fillOval(e.getX(), e.getY(), xSize, ySize);
			
		}
		
		public void mouseMoved(MouseEvent e){}
	}
	
	public static void main (String[]args){
		new Main();
	}
}