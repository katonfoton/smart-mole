package View;

import javax.swing.*;

import Model.Game;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class WinWindow extends JFrame{
	private static final int WIDTH = 360;
	private static final int HEIGHT = 200;
	private JPanel winPanel;
	private JButton backButton;
	private JTextField textName;
	private JLabel enterName;
	private String getName;
	
	public WinWindow() {
		setTitle("Уведомление");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setResizable(false);
		paintPanel();
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void paintPanel() {
		winPanel = new JPanel();
		winPanel.setBackground(new Color(194,253,255));
		winPanel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		winPanel.setLayout(null);
		add(winPanel);
		winText();
		enterName();
		returnMenu();	
	}
	
	public void winText() {
		JLabel win = new JLabel("УРОВЕНЬ ПРОЙДЕН!");
		win.setFont(new Font("Undertale Battle Font", Font.PLAIN, 35));
		win.setForeground(Color.BLACK);
		win.setBounds(0, -70, WIDTH, HEIGHT);
		win.setHorizontalAlignment(win.CENTER);
		winPanel.add(win);
		JLabel score = new JLabel("очки за игру: " + Game.getScore());
		score.setFont(new Font("Undertale Battle Font", Font.PLAIN, 30));
		score.setForeground(Color.BLACK);
		score.setBounds(0, -35, WIDTH, HEIGHT);
		score.setHorizontalAlignment(score.CENTER);
		winPanel.add(score);
	}
	
	public void enterName() {
		textName = new JTextField();
		textName.setBounds(140, 100, 200, 35);
		textName.setFont(new Font("Undertale Battle Font", Font.ITALIC, 20));
		enterName = new JLabel("ваше имя: ");
		enterName.setFont(new Font("Undertale Battle Font", Font.ITALIC, 20));
		enterName.setBounds(20, 100, 150, 35);
		winPanel.add(textName);
		winPanel.add(enterName);
	}
	
	public void returnMenu() {
		Font font = new Font("Undertale Battle Font", Font.PLAIN, 30);
		backButton = new JButton("ОК");
		backButton.setFont(font);
		backButton.setForeground(Color.BLACK);
		backButton.setBackground(new Color(206,230,164));
		backButton.setBounds(120, 155, 120, 35);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getName = textName.getText();
				if(getName.length() != 0) {
					try(FileWriter writer = new FileWriter("src/files/table.txt", true))
					{	
						writer.write(getName + " ");
					    writer.append(String.valueOf(Game.getScore()) + " ");
					    writer.append("\n");
					    writer.close();
					}catch(IOException ex){ 
					    System.out.println(ex.getMessage());
					}
				}
				MainWindow.c1.show(MainWindow.panelCont, "menu");
				dispose();
			}
		});
		winPanel.add(backButton);
		}
}





