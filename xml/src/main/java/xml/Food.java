package xml;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.*;

@SuppressWarnings("WeakerAccess")
@Accessors(chain = true, fluent = true)
@Data
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Food", propOrder = { "name", "price", "description", "calories" })
public class Food {
    @XmlAttribute(required = true)
    private int id;

    @XmlElement(required = true)
    private String name;

    @XmlElement(required = true)
    private String price;

    @XmlElement(required = true)
    private String description;

    @XmlElement(required = true)
    private int calories;
}
