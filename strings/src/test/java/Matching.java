import lombok.experimental.var;
import lombok.val;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Matching {
    @Test
    public void test() throws Exception {
        val str1 = "Hello";
        var str2 = new String(str1);

        assertFalse(str1 == str2);
        assertEquals(str1, str2);

        str2 = str2.intern();
        assertTrue(str1 == str2);
        assertThat(str1, is(str2));
    }
}
