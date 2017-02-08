package xml.stax;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class StAXFileWriterTest {
    @Test
    public void writeToFile() throws Exception {
        File file = new File("src/test/resources/output2.xml");
        StAXFileWriter.writeToFile(file);
        Assert.assertTrue(file.exists());
        Assert.assertEquals(76, file.length());
    }

}