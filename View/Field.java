package View;
import javax.swing.*;

import Model.Game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Field extends JPanel {
	private static final int SCREEN_WIDTH = 720;
	private static final int SCREEN_HEIGHT = 630;
	private static final int UNIT_WIDTH = 40;
	private static final int UNIT_HEIGHT = 35;
	private static final int SIZE = 18;
	private int[] x = new int[SIZE];
	private int[] y = new int[SIZE];
    
    private static ImageIcon mole;
    private static JLabel labelMole;
    
    private Action upAction;
    private Action downAction;
    private Action leftAction;
    private Action rightAction;
	
	private Image wall = new ImageIcon("src/images/wall.jpg").getImage();
	private Image box = new ImageIcon("src/images/donebox.png").getImage();
	private Image doneBox = new ImageIcon("src/images/box.png").getImage();
	private Image seed = new ImageIcon("src/images/seed.png").getImage();
	private static JLabel labelSteps;
    private static JButton backButton; 
    
	public Field() {
		setBackground(new Color(255,192,203));
		setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		setLayout(null);
		upAction = new UpAction();
		downAction = new DownAction();
		leftAction = new LeftAction();
		rightAction = new RightAction();
		markup();
		mole();
		printSteps();
		setInputMap(WHEN_ANCESTOR_OF_FOCUSED_COMPONENT, getInputMap());
		labelMole.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"), "upAction");
		labelMole.getActionMap().put("upAction", upAction);
		labelMole.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"), "downAction");
		labelMole.getActionMap().put("downAction", downAction);
		labelMole.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "leftAction");
		labelMole.getActionMap().put("leftAction", leftAction);
		labelMole.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), "rightAction");
		labelMole.getActionMap().put("rightAction", rightAction);
		returnMenu();
	}
	
	public static void initGame(String txt){
		Game g = new Game(txt);
		labelMole.setLocation(Game.moleX() * UNIT_WIDTH, Game.moleY() * UNIT_HEIGHT);
		labelSteps.setText("Шаги: " + Game.steps());
	 }
	
	public void markup() {
		 for(int i = 0;i < SCREEN_WIDTH/UNIT_WIDTH;i++) {
			x[i] = i*UNIT_WIDTH;
		 }
		 for(int i = 0;i < SCREEN_HEIGHT/UNIT_HEIGHT;i++) {
			y[i] = i*UNIT_HEIGHT;
		}
	 }
	 
	public void mole() {
		mole = new ImageIcon("src/images/mole.png");
		labelMole = new JLabel(mole);
		labelMole.setBounds(Game.moleX() * UNIT_WIDTH, Game.moleY() * UNIT_HEIGHT, UNIT_WIDTH, UNIT_HEIGHT);
		add(labelMole);
	}
	
	public void printSteps() {
		Font font = new Font("Undertale Battle Font", Font.PLAIN, 30);
		labelSteps = new JLabel("Шаги: 0");
		labelSteps.setFont(font);
		labelSteps.setForeground(Color.WHITE);
		labelSteps.setBounds( 40 , 595 , 4*UNIT_WIDTH, UNIT_HEIGHT);
		add(labelSteps);
	}
	
	public void returnMenu() {
		Font font = new Font("Undertale Battle Font", Font.PLAIN, 30);
		backButton = new JButton("Меню");
		backButton.setFont(font);
		backButton.setForeground(Color.WHITE);
		backButton.setBackground(Color.BLACK);
		backButton.setBounds(560, 595, 3*UNIT_WIDTH, UNIT_HEIGHT); 
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindow.c1.show(MainWindow.panelCont, "menu");
			}
		});
		this.add(backButton);
	}
			 
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(int i=0;i<SCREEN_WIDTH/UNIT_WIDTH;i++) {
			g.drawLine(i*UNIT_WIDTH, 0, i*UNIT_WIDTH, SCREEN_HEIGHT);
		}
		for(int i=0;i<SCREEN_HEIGHT/UNIT_HEIGHT;i++) {
			g.drawLine(0, i*UNIT_HEIGHT, SCREEN_WIDTH, i*UNIT_HEIGHT);
		}
		
		for(int i = 0;i < SIZE;i++) {
			for(int j = 0;j < SIZE;j++) {
				if(Game.checkWalls(i,j)) {
					g.drawImage(wall,x[i],y[j],this);
				}
			}
		}
		
		for(int i = 0;i < SIZE;i++) {
			for(int j = 0;j < SIZE;j++) {
				if(Game.checkBox(i, j)) {
					g.drawImage(box,x[i],y[j],this);
				}
			}
		}
		
		for(int i = 0;i < SIZE;i++) {
			for(int j = 0;j < SIZE;j++) {
				if(Game.checkSeed(i, j)) {
					g.drawImage(seed,x[i],y[j],this);
				}
			}
		}
		
		for(int i = 0;i < SIZE;i++) {
			for(int j = 0;j < SIZE;j++) {
				if(Game.checkDoneBox(i,j)) {
					g.drawImage(doneBox,x[i],y[j],this);
				}
			}
		}
	}
	
	public class UpAction extends AbstractAction{
		public void actionPerformed(ActionEvent e) {
			if(Game.moveUp()) {
				labelMole.setLocation(Game.moleX() * UNIT_WIDTH, Game.moleY() * UNIT_HEIGHT);
				labelSteps.setText("Шаги: " + Game.steps());
				if(Game.win()) {
	    			WinWindow ww = new WinWindow();
				}
			}		
		}
	}
		
	public class DownAction extends AbstractAction{
		public void actionPerformed(ActionEvent e) {
			if(Game.moveDown()) {
				labelMole.setLocation(Game.moleX() * UNIT_WIDTH, Game.moleY() * UNIT_HEIGHT);
				labelSteps.setText("Шаги: " + Game.steps());
				if(Game.win()) {
	    			WinWindow ww = new WinWindow();
				}
      		}
		}
	}		

	public class LeftAction extends AbstractAction{
		public void actionPerformed(ActionEvent e) {
			if(Game.moveLeft()) {
				labelMole.setLocation(Game.moleX() * UNIT_WIDTH, Game.moleY() * UNIT_HEIGHT);
				labelSteps.setText("Шаги: " + Game.steps());
				if(Game.win()) {
	    			WinWindow ww = new WinWindow();
				}
			}
		}		
	}
	public class RightAction extends AbstractAction{
		public void actionPerformed(ActionEvent e) {
			if(Game.moveRight()) {
				labelMole.setLocation(Game.moleX() * UNIT_WIDTH, Game.moleY() * UNIT_HEIGHT);
				labelSteps.setText("Шаги: " + Game.steps());
				if(Game.win()) {
	    			WinWindow ww = new WinWindow();
				}
			}
		}		
	}
}