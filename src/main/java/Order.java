import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data


public record Order(String id, List<Product> products, OrderStatus status) {

    public enum OrderStatus {
        PROCESSING, IN_DELIVERY, COMPLETED
    }

    public Order(String id, List<Product> products) {
        this(id, products, OrderStatus.PROCESSING);
    }

}
