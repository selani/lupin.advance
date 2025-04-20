import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.nio.charset.Charset;
import java.util.Map;

/**
 * KSC5601      = KSC5601-1987
 * EUCKR        = KSC5601-1987 + KSC5636(한글이외 문자표시규약)
 * CP949        = KSC5601-1987 + 확장한글
 * MS949        = KSC5601-1992 + 확장한글
 * UTF8         = 데이터 송수신 권장 문자셋, 최대 6 bytes, 한글 3 bytes, 영문 1 byte
 * AL32UTF8     = Oracle 9i 이상 기본 문자셋, 최대 4 bytes, 한글 3 bytes, 영문 1 byte
 * KO16MSWIN949 = Oracle 한글 문자셋, 한글 2 bytes
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
        // String[] ca = {"KSC5601", "EUCKR", "CP949", "MS949", "UTF8"};
        String[] ca = {"X-ORACLE-KO16KSC5601", "X-ORACLE-KO16MSWIN949", "UTF-8", "X-ORACLE-AL32UTF8"};
        for (String s : sa) {
            for (String c : ca) {
                byte[] ba = s.getBytes(c);
                String d = c.replace("X-ORACLE-", "");
                System.out.printf("%-12s : %s > %s (%2d) [ ", d, s, pad(new String(ba, c)), ba.length);
                for (byte b : ba) System.out.printf("%02x ", b);
                System.out.printf("] %n");
            }
            System.out.println();
        }
    }

    @Test
    public void t2() {
        // Charset.availableCharsets().values().forEach(System.out::println);
    }

    @Test
    public void t3() {
        Map<String, Charset> map = Charset.availableCharsets();
        for (String k : map.keySet()) {
            Charset c = map.get(k);
            if (k.matches(".*(16).*"))
                System.out.printf("%s, %s, %s %n", k, c.name(), c.displayName());
        }
    }
}
