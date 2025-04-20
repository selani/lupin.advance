import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.nio.charset.Charset;

/**
 * KSC5601  = KSC5601-1987
 * EUCKR    = KSC5601-1987 + KSC5636(한글이외 문자표시규약)
 * CP949    = KSC5601-1987 + 확장한글
 * MS949    = KSC5601-1992
 * UTF8     = 데이터 송수신 권장 문자셋, 최대 6 byte, 한글 3 byte, 영문 1 byte
 * AL32UTF8 = Oracle 9i 이상 기본 문자셋, 최대 4 byte, 한글 3 byte, 영문 1 byte
 */
public class CharsetTest {

    public static String pad(String s) {
        int x = 0;
        for (char c : s.toCharArray()) if (c == 0x3f) x++;
        return s.concat(StringUtils.repeat(' ', x));
    }

    @Test
    public void t1() throws Exception {
        String[] sa = {"오렌즤", "오렌즥", "똠뷱뾸", "なんて", "新的开"};
        String[] ca = {"KSC5601", "EUCKR", "CP949", "MS949", "UTF8"};
        for (String s : sa) {
            for (String c : ca) {
                byte[] ba = s.getBytes(c);
                System.out.printf("%s > %s : %-7s (%2d) [ ", s, pad(new String(ba, c)), c, ba.length);
                for (byte b : ba) System.out.printf("%02x ", b);
                System.out.printf("] %n");
            }
            System.out.println();
        }
    }

    @Test
    public void t2() {
        Charset.availableCharsets().values().forEach(System.out::println);
    }
}
