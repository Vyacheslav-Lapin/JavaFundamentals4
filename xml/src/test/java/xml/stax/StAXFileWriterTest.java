package xml.stax;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

import static xml.Tests.RESOURCES_FILE_PATH;

public class StAXFileWriterTest {
    @Test
    public void writeToFile() throws Exception {
        File file = new File(RESOURCES_FILE_PATH + "output2.xml");
        StAXFileWriter.writeToFile(file);
        Assert.assertTrue(file.exists());
        Assert.assertEquals(76, file.length());
    }

}