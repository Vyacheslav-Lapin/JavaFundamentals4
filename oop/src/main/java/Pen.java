import lombok.*;

@AllArgsConstructor
@Value
@Builder
public class Pen {
    private final int price;
    private final String producerName;

    public static void main(String[] args) {

        val pen = Pen.builder()
                .price(1)
                .producerName("")
                .build();

        pen.equals(new Pen(1, ""));
    }
}
