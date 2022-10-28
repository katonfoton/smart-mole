package IO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import View.MainWindow;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

public class Table extends JPanel{
	private static final int SCREEN_WIDTH = 720;
	private static final int SCREEN_HEIGHT = 630;
	private static final int ROWS = 10;
	private static final int COLUMNS = 3;
	private JTable table;	
	private static Object [][] rowData = new String [ROWS][COLUMNS];
	private String [] columnNames = new String [COLUMNS];
	private static Map <String, Integer> map = new TreeMap<String, Integer>() ;
	private JButton backButton;

	public Table() {
		setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		setBackground(new Color(194,253,255));
		setLayout(new BorderLayout());
		sortTable();
		setTable();
		columnNames[0] = "Место";
	    columnNames[1] = "Имя";
	    columnNames[2] = "Очки";
	    for(int i = 0; i < ROWS; i++) {
	    	rowData[i][0] = String.valueOf(i + 1);
	    }
		table = new JTable(rowData, columnNames);
		printTable(); 
		returnMenu();
	}
	
	public static void sortTable() {
		Scanner sc = null;
		try {
			sc = new Scanner(new File("src/files/table.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(sc.hasNext()){
			map.put(sc.next(), sc.nextInt());
    	}
		sc.close();
		MyComparator comp = new MyComparator(map);
		Map<String, Integer> newMap = new TreeMap(comp);
		newMap.putAll(map);	
		try(FileWriter writer = new FileWriter("src/files/table.txt", false))
		{	
			for (Map.Entry<String, Integer> entry : newMap.entrySet()) {
			writer.write(entry.getKey() + " " + entry.getValue());
		    writer.append("\n");
			}
		    writer.close();
		}catch(IOException ex){ 
		    System.out.println(ex.getMessage());
		}
	}
	
	public void printTable() {
		
		table.setBackground(new Color(255,192,203));
		table.setGridColor(Color.BLACK);
        table.getTableHeader().setBackground(new Color(194,253,255));
	    table.setFont(new Font("Undertale Battle Font", Font.PLAIN, 30));
//	    add(table.getTableHeader(), BorderLayout.NORTH);
		add(BorderLayout.CENTER, new JScrollPane(table));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setRowHeight(50);
        TableColumn a = table.getColumnModel().getColumn(0);
        a.setPreferredWidth(110);
        TableColumn b = table.getColumnModel().getColumn(1);
        b.setPreferredWidth(496);
        TableColumn c = table.getColumnModel().getColumn(2);
        c.setPreferredWidth(110); 
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int x = 0;x < COLUMNS;x++){
            table.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
           }
	}
	
	public static void setTable() {
		Scanner sc = null;
		try {
			sc = new Scanner(new File("src/files/table.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    for(int i = 0; i < ROWS; i++) {
	    	while(sc.hasNext()){
	    		rowData[i][1] = sc.next();
	    		rowData[i][2] = String.valueOf(sc.nextInt());
	    		break;
	    	}
	    }
	    sc.close();
	}
	
	public void returnMenu() {
		Font font = new Font("Undertale Battle Font", Font.PLAIN, 30);
		backButton = new JButton("ОК");
		backButton.setFont(font);
		backButton.setForeground(Color.BLACK);
		backButton.setBackground(new Color(194,253,255));
		backButton.setSize(120, 35);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindow.c1.show(MainWindow.panelCont, "menu");
			}
		});
		add(backButton, BorderLayout.SOUTH);
		}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < ROWS; i++){
			for(int j = 0; j < COLUMNS; j++){ 
				sb.append(rowData[i][j] + " ");
			}
			sb.append("\n");
		}
		String text = sb.toString();
		return text; 
	}
}



