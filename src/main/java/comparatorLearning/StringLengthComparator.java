package comparatorLearning;

import java.util.Comparator;

public class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) { // сортанем строки по длине
        if (o1.length() > o2.length()) return 1;
        else if (o1.length() < o2.length()) return -1;
        else return 0;
    }
}
