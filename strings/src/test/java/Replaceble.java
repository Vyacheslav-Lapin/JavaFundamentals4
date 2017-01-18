import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Replaceble {
    @Test
    public void test() throws Exception {
        String str = "Her name is Tamara. Tamana is a good girl.";
        String strreplace = "Sonia";
        assertThat(
                str.replaceFirst("Tamana", strreplace),
                is("Her name is Tamara. Sonia is a good girl."));
    }

}
