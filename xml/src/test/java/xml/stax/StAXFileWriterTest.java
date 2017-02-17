package xml.stax;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.epam.courses.jf.test.Tests.RESOURCES_FILE_PATH;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StAXFileWriterTest {
    @Test
    void writeToFile() throws Exception {
        File file = new File(RESOURCES_FILE_PATH + "output2.xml");
        StAXFileWriter.writeToFile(file);
        assertTrue(file.exists());
        assertEquals(76, file.length());
    }

}