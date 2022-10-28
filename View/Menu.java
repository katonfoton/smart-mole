package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import IO.Table;

public class Menu extends JPanel implements MouseMotionListener, MouseListener{
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

	
	public Menu() {
		setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		setLayout(null);
		list[0] = "новая игра";
		list[1] = "мои игры";
		list[2] = "выход";
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
			list[0] = "НОВАЯ ИГРА";
			repaint();
		}else {
			list[0] = "новая игра";
			repaint();
			}
		if (mouseX > xButton && mouseX < xButton + BUTTON_WIDTH &&
                mouseY >(yButton + 110*1) && mouseY <(yButton + 110*1) + BUTTON_HEIGHT) {
			list[1] = "МОИ ИГРЫ";
			repaint();
		}else {
			list[1] = "мои игры";
			repaint();
			}
		if (mouseX > xButton && mouseX < xButton + BUTTON_WIDTH &&
                mouseY >(yButton + 110*2) && mouseY <(yButton + 110*2) + BUTTON_HEIGHT) {
			list[2] = "ВЫХОД";
			repaint();
		}else {
			list[2] = "выход";
			repaint();
			}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			if (mouseX > xButton && mouseX < xButton + BUTTON_WIDTH &&
	                mouseY >(yButton + 110*0) && mouseY <(yButton + 110*0) + BUTTON_HEIGHT) {
				MainWindow.c1.show(MainWindow.panelCont, "levels_menu");
			}
		}
		if (e.getButton() == MouseEvent.BUTTON1) {
			if (mouseX > xButton && mouseX < xButton + BUTTON_WIDTH &&
	                mouseY >(yButton + 110*1) && mouseY <(yButton + 110*1) + BUTTON_HEIGHT) {
				Table.sortTable();
				Table.setTable();
				MainWindow.c1.show(MainWindow.panelCont, "table");
			}
		}
		if (e.getButton() == MouseEvent.BUTTON1) {
			if (mouseX > xButton && mouseX < xButton + BUTTON_WIDTH &&
	                mouseY >(yButton + 110*2) && mouseY <(yButton + 110*2) + BUTTON_HEIGHT) {
				System.exit(1);
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