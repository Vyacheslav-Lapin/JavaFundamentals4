package xml.sax;

import lombok.SneakyThrows;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public interface JaxpSaxDemo {

    @SneakyThrows
    static <T extends DefaultHandler> T parse(File file, T defaultHandler) {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setValidating(false);
        javax.xml.parsers.SAXParser sp = spf.newSAXParser();
        sp.parse(file, defaultHandler);
        return defaultHandler;
    }
}
