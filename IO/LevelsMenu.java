package IO;
import javax.swing.*;

import View.Field;
import View.MainWindow;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class LevelsMenu extends JPanel implements MouseMotionListener, MouseListener{
	private static final int SCREEN_WIDTH = 720;
	private static final int SCREEN_HEIGHT = 630;
	private final int BUTTONS = 3;
	private final static int BUTTON_WIDTH = 250;
	private final static int BUTTON_HEIGHT = 90;
	
	private double xButton = 230;
	private double yButton = 100;
	private double mouseX;
	private double mouseY;
	
	private Image backround = new ImageIcon("src/images/fon1.png").getImage();
	private Image button1 = new ImageIcon("src/images/button_1.png").getImage();
	private Image button2 = new ImageIcon("src/images/button_2.png").getImage();
	private Image button3 = new ImageIcon("src/images/button_3.png").getImage();
	private Color color1 = Color.WHITE ;
	private String [] list = new String[BUTTONS];
	private JButton backButton;
	
	
	public LevelsMenu() {
		setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		setLayout(null);
		setFocusable(true);
		requestFocus();
		list[0] = "уровень 1";
		list[1] = "уровень 2";
		list[2] = "уровень 3";
		returnMenu();
		addMouseMotionListener(this);
		addMouseListener(this);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backround,0,0,this);
		g.drawImage(button1,(int)xButton,(int)yButton,this);
		g.drawImage(button2,(int)xButton,(int)yButton + 110,this);
		g.drawImage(button3,(int)xButton,(int)yButton + 220,this);
		for(int i = 0; i < 3; i++) {
			Font font = new Font("Undertale Battle Font", Font.PLAIN, 35);
			g.setFont(font);
			g.setColor(color1);
			long length = (int) g.getFontMetrics().getStringBounds(list[i], g).getWidth();
			g.drawString(list[i], (int) (xButton + BUTTON_WIDTH / 2) - (int) (length / 2), (int) (yButton + (BUTTON_HEIGHT/ 3)*2)+ 110*i);
		}
	}
	
	public void returnMenu() {
		Font font = new Font("Undertale Battle Font", Font.PLAIN, 30);
		backButton = new JButton("Меню");
		backButton.setFont(font);
		backButton.setForeground(Color.WHITE);
		backButton.setBackground(Color.BLACK);
		backButton.setBounds(600, 595, 120, 35);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindow.c1.show(MainWindow.panelCont, "menu");
			}
		});
		add(backButton);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		if (mouseX > xButton && mouseX < xButton + BUTTON_WIDTH &&
                mouseY >(yButton + 110*0) && mouseY <(yButton + 110*0) + BUTTON_HEIGHT) {
			list[0] = "УРОВЕНЬ 1";
			repaint();
		}else {
			list[0] = "уровень 1";
			repaint();
			}
		if (mouseX > xButton && mouseX < xButton + BUTTON_WIDTH &&
                mouseY >(yButton + 110*1) && mouseY <(yButton + 110*1) + BUTTON_HEIGHT) {
			list[1] = "УРОВЕНЬ 2";
			repaint();
		}else {
			list[1] = "уровень 2";
			repaint();
			}
		if (mouseX > xButton && mouseX < xButton + BUTTON_WIDTH &&
                mouseY >(yButton + 110*2) && mouseY <(yButton + 110*2) + BUTTON_HEIGHT) {
			list[2] = "УРОВЕНЬ 3";
			repaint();
		}else {
			list[2] = "уровень 3";
			repaint();
			}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			if (mouseX > xButton && mouseX < xButton + BUTTON_WIDTH &&
	                mouseY >(yButton + 110*0) && mouseY <(yButton + 110*0) + BUTTON_HEIGHT) {
				Field.initGame("src/files/level1.txt");
				MainWindow.c1.show(MainWindow.panelCont, "play");
				
			}
		}
		if (e.getButton() == MouseEvent.BUTTON1) {
			if (mouseX > xButton && mouseX < xButton + BUTTON_WIDTH &&
	                mouseY >(yButton + 110*1) && mouseY <(yButton + 110*1) + BUTTON_HEIGHT) {
				Field.initGame("src/files/level2");
				MainWindow.c1.show(MainWindow.panelCont, "play");
				
			}
		}
		if (e.getButton() == MouseEvent.BUTTON1) {
			if (mouseX > xButton && mouseX < xButton + BUTTON_WIDTH &&
	                mouseY >(yButton + 110*2) && mouseY <(yButton + 110*2) + BUTTON_HEIGHT) {
				Field.initGame("src/files/level3");
				MainWindow.c1.show(MainWindow.panelCont, "play");
				
			}
		}
	}
	

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
