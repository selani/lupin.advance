package lupin.coree.jdt.core;

import java.util.LinkedList;
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
            T a = new T();
            a.y = Y.IMPORTS;
        }
    }

    public static class L extends LinkedList<T> {
        public T p;
    }

    public static enum Y {
        FILE, IMPORTS, MIDIFIER, CLASS, METHOD, PARENTHESES, BRACE, BRACKETS, SEMICOLON;
    }
}
