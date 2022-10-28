package IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;

public class MyComparator implements Comparator{
	Map<String, Integer> map;

    public MyComparator(Map<String, Integer> map) {
        this.map = map;
    }

    public int compare(Object o1, Object o2) {
        if (map.get(o2) == map.get(o1))
            return 1;
        else
            return ((Integer) map.get(o2)).compareTo((Integer)
                    map.get(o1));

    }
}
