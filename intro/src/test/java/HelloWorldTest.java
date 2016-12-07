import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HelloWorldTest {

    @Test
    public void постфиксныйИнкрементРаботаетПравильно() throws Exception {

        int i=3;
        int k = 1;
//        i = -i++ + i++ + -i;
//        System.out.println(i);

        int i2;
        int i3;
        int i4;
        int i5;

        assertThat(i2 = -i++, is(-3));
        assertThat(i, is(4));

        assertThat(i3 = i++, is(4));
        assertThat(i, is(5));

        assertThat(i4 = -i, is(-5));
        assertThat(i, is(5));

        assertThat(i5 = i2 + i3, is(1));
        assertThat(i, is(5));

        assertThat(i5 + i4, is(-4));
        assertThat(i, is(5));
    }
}