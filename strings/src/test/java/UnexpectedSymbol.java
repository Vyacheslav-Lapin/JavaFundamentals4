import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class UnexpectedSymbol {
    @Test
    public void test() throws Exception {
        String attention = "Внимание: ";
        String s1 = attention.concat("!!!");
        String s2 = attention + " неизвестный символ";

        assertThat(s1, is("Внимание: !!!"));
        assertThat(s2, is("Внимание:  неизвестный символ"));

        String str1 = "2" + 2 + 2;
        String str2 = 2 + 2 + "2";
        String str3 = "2" + (2 + 2);

        assertThat(str1, is("222"));
        assertThat(str2, is("42"));
        assertThat(str3, is("24"));
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void npeTest() throws Exception {
        String s1 = null;
        s1.concat("abc");
    }

    @Test
    public void exceptionalTest() throws Exception {
        String s2 = null;
        assertThat(s2 + "abc", is("nullabc"));
// concat() returns new String
// object only when the length of
// argument string is > 0.
        String s3 = "Blue";
        String s4 = "Sky!";
        String s5 = s3.concat(s4);
        assertFalse(s5 == s3);
        String s6 = "abc";
        String s7 = s6.concat("");
        assertTrue(s6 == s7);
    }
}
