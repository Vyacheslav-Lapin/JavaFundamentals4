import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class Matching {
    @Test
    public void test() throws Exception {
        String str1="Hello";
        String str2=new String("Hello");

        assertFalse(str1 == str2);

        str2 = str2.intern();
        assertTrue(str1 == str2);
        assertThat(str1, is(str2));
    }
}
