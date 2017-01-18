import lombok.SneakyThrows;
import lombok.val;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DateTimeTest {
    @Test
    @SneakyThrows
    public void test() {
        val sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        val dateInString = "31-08-1982 10:20:56";
        Date date = sdf.parse(dateInString);
        assertThat(date.toString(), is("Tue Aug 31 10:20:56 MSD 1982"));
    }

    @Test(expected = ParseException.class)
    @SneakyThrows
    public void test2() {
        val sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        val dateInString = "31-08-1982 jhdagdgstsgb 10:20:56";
        Date date = sdf.parse(dateInString);
        assertThat(date.toString(), is("Tue Aug 31 10:20:56 MSD 1982"));
    }
}
