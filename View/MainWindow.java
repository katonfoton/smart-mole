package View;
import javax.swing.*;
import IO.LevelsMenu;
import IO.Table;
import java.awt.*;

public class MainWindow extends JFrame{
	public static CardLayout c1 = new CardLayout();
	public static JPanel panelCont = new JPanel();
	 
	public MainWindow() {
		panelCont.setLayout(c1);
		panelCont.add(new Menu(), "menu");
		panelCont.add(new LevelsMenu(), "levels_menu");
		panelCont.add(new Field(), "play");
		panelCont.add(new Table(), "table");
		c1.show(panelCont, "menu");
		add(panelCont);
		setTitle("Умный крот");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);		
	}
	
	public static void main(String[] args) {
		MainWindow mw = new MainWindow();
	}
}
