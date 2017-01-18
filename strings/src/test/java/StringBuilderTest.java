import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StringBuilderTest {

    @Test
    public void test0() throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("Java StringBuilder");
        assertThat(sb.toString(), is("Java StringBuilder"));
        sb.append(" Example");
        assertThat(sb.toString(), is("Java StringBuilder Example"));
    }

    @Test
    public void test1() throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("Java StringBuilder");
        sb.insert(5, "insert ");
        assertThat(sb.toString(), is("Java insert StringBuilder"));
    }

    @Test
    public void test2() throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("Java tringBuilder");
        sb.setCharAt(5, 'S');
        assertThat(sb.toString(), is("Java SringBuilder"));
    }
}
