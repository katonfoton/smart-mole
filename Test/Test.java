package Test;

import Model.Game;

public class Test {
	
	    private static int total;
	    private static int failed;

	    public static void showStat() {
	        if (failed == 0) {
	            System.out.println("\nOK");
	        }
	        else
	            System.out.println(failed + " tests of " + total + " failed.");
	    }

	    private static void check(boolean b) {
	        total++;
	        if (!b) {
	            failed++;
	            throw new RuntimeException("Test failed.");
	        }
	        System.out.print(".");
	    }

	    public static void testMove1() {
	        Game g = new Game("src/files/level1.txt");
	        check(g.moveUp() == false);
	    }

	    public static void testMove2() {
	    	Game g = new Game("src/files/level1.txt");
	        check(g.moveRight());
	    }
	    
	    public static void testGetSeed() {
	    	 Game g = new Game("src/files/level1.txt");
	    	 check(g.getSeed(4,3));
	    }
	    
	    public static void testSetSeed() {
	    	 Game g = new Game("src/files/level1.txt");
	    	 check(g.setSeed(10,2) == false);
	    }


	    public static void runTests() {
	        testMove1();
	        testMove2();
	        testGetSeed();
	        testSetSeed();
	    }

	    public static void main(String[] args) {
	        Test.runTests();
	        Test.showStat();
	    }
	}

