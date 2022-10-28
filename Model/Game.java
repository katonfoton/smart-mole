package Model;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {	
	private static final int SIZE = 18;
	private static int [][] field = new int [SIZE][SIZE];
	
	private static boolean seed;
	private static int boxes;
	private static int doneBoxes;
	private static int steps;
	private static int minSteps;
	private static boolean win;
	
	private static int moleX;
	private static int moleY;
	
	public Game(String txt) {
		Scanner sc = null;
		try {
			sc = new Scanner(new File(txt));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < SIZE; i ++) {
			for(int j = 0; j < SIZE; j++) {
				field[j][i] = sc.nextInt();
			}
		}
		steps = 0;
		minSteps = sc.nextInt();
		for(int i = 0; i < SIZE; i ++) {
			for(int j = 0;j < SIZE; j++) {
				if(field[i][j] == 5) {
					moleX = i;
					moleY = j;
				}
			}
		}
		sc.close();
		boxes = 0;
		for(int i = 0; i < SIZE; i ++) {
			for(int j = 0;j < SIZE; j++) {
				if(field[i][j] == 3) {
					boxes ++;
				}
			}
		}
		doneBoxes = 0;
		seed = false;
		win = false;
	}
	
	public Game () {
		walls();
	}
	
	public void walls() {
		for(int i = 0; i < SIZE; i++){
			field[i][0] = 1;
			field[SIZE - 1][i] = 1;
			field[i][SIZE - 1] = 1;
			field[0][i] = 1;
		}	
	}
	
	public static int moleX() {
		return moleX;
	}
	
	public static int moleY() {
		return moleY;
	}
	
	public static boolean moveUp() {
		if(checkWalls(moleX,moleY - 1) == false) {
			moleY --;
    		getSeed(moleX, moleY);
    		setSeed(moleX, moleY);
    		steps++;
//    		if(win()) {
//    			WinWindow ww = new WinWindow();
//    		}
    		return true;
    	} else
    		return false;
	}
	
	public static boolean moveDown() {
		if(checkWalls(moleX,moleY + 1) == false) {
			moleY ++;
    		getSeed(moleX, moleY);
    		setSeed(moleX, moleY);
    		steps++;
//    		if(win()) {
//    			WinWindow ww = new WinWindow();
//    		}
    		return true;
    	} else
    		return false;
	}
	
	public static boolean moveLeft() {
		if(checkWalls(moleX - 1,moleY) == false) {
			moleX --;
    		getSeed(moleX, moleY);
    		setSeed(moleX, moleY);
    		steps++;
//    		if(win()) {
//    			WinWindow ww = new WinWindow();
//    		}
    		return true;
    	} else
    		return false;
	}
	
	public static boolean moveRight() {
		if(checkWalls(moleX + 1,moleY) == false) {
			moleX ++;
    		getSeed(moleX, moleY);
    		setSeed(moleX, moleY);
    		steps++;
//    		if(win()) {
//    			WinWindow ww = new WinWindow();
//    		}
    		return true;
    	} else
    		return false;
	}
	
	public static int steps() {
		return steps;
	}
	
	public static boolean checkWalls(int i, int j) {
		if(field[i][j] == 1)
			return true;
		else 
			return false;
	}
	
	public static boolean checkSeed(int i, int j) {
		if(field[i][j] == 2)
			return true;
		else 
			return false;
	}
	
	public static boolean checkBox(int i, int j) {
		if(field[i][j] == 3)
			return true;
		else 
			return false;
	}
	
	public static boolean checkDoneBox(int i, int j) {
		if(field[i][j] == 4)
			return true;
		else 
			return false;
	}
	
	public static boolean getSeed(int i, int j) {
		if(field[i][j] == 2 && seed == false) {
			field[i][j] = 0;
			seed = true;
			return true;
		}else
			return false;
	}
	
	public static boolean setSeed(int i, int j) {
		if(field[i][j] == 3 && seed == true) {
			field[i][j] = 4;
			seed = false;
			doneBoxes++;
			return true;
		}else
			return false;
	}
	
	public static int getScore() {
		return minSteps*10/steps;
	}
	
	public static boolean win() {
		if(boxes == doneBoxes) {
			win = true;
		}
		return win;
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < SIZE; i++){
			for(int j = 0; j < SIZE; j++){ 
				sb.append(field[i][j] + " ");
			}
			sb.append("\n");
		}
		String text = sb.toString();
		return text; 
	}

	public static void main(String[] args) {
		//Game g = new Game("src/level1.txt");
//		Game t = new Game();
//		System.out.println(t);
		
	}
}
