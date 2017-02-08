package xml;

import lombok.Builder;
import lombok.Value;

@SuppressWarnings("WeakerAccess")
@Value
@Builder
public class Food {
    private int id;
    private String name;
    private String price;
    private String description;
    private int calories;
}
