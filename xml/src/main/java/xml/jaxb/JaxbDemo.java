package xml.jaxb;

import lombok.SneakyThrows;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileOutputStream;

@FunctionalInterface
public interface JaxbDemo<T> {

    @Private
    JAXBContext getContext();

    @SneakyThrows
    static <T> JaxbDemo<T> from(Class<T> tClass) {
        JAXBContext context = JAXBContext.newInstance(tClass);
        return () -> context;
    }

    @SneakyThrows
    default void marshal(T object, File file) {
        Marshaller m = getContext().createMarshaller();
        m.marshal(object, new FileOutputStream(file));
    }

    @SneakyThrows
    default T unmarshal(File file) {
        Unmarshaller unmarshaller = getContext().createUnmarshaller();
        //noinspection unchecked
        return (T) unmarshaller.unmarshal(file);
    }
}
