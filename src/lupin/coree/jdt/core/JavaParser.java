package lupin.coree.jdt.core;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.regex.Matcher;

public class JavaParser {

    public int parse(T t, Matcher m, int i) {

        return 0;
    }

    public static class T {
        public String g;
        public T p;
        public Y y;
        public L s1, s2, l;

        void parse() {
            L m = new L();

            for (T t : l) {
                if (t.y == Y.MIDIFIER) m.add(t);

            }
        }
    }

    public static class L extends LinkedList<T> {

    }

    public static enum Y {
        FILE, IMPORTS, MIDIFIER, CLASS, METHOD, PARENTHESES, BRACE, BRACKETS, SEMICOLON, EMPTY;
    }
}
