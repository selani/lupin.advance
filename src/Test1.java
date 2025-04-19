public class Test1 {
    public static void main(String[] args) throws Exception {
        String[] sa = {"뽀또샾", "오렌쥥", "똠방각하"};
        String[] ca = {"CP949", "MS949", "UTF8"};
        for (String s : sa) {
            for (String c : ca) {
                byte[] ba = s.getBytes(c);
                System.out.printf("%s -> %-6s -> %s  : (%2d)[", s, c, new String(ba, c), ba.length);
                for (byte b : ba) System.out.printf("%02x ", b);
                System.out.println("]");
            }
        }
    }
}
