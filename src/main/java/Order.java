import lombok.*;

import java.lang.reflect.Method;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@With

public record Order(String id, List<Product> products, OrderStatus status, Instant timestamp) {
    @Override
    public String id() {
        return id;
    }

    @Override
    public Instant timestamp() {
        return Instant.now(); // Replace with your actual logic
    }

    @Override
    public List<Product> products() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(products, order.products) && status == order.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, products, status);
    }

    public Order {
    }

    @Override
    public OrderStatus status() {
        return OrderStatus.PROCESSING;
    }

    public Object getId() {
        return id;
    }





    public enum OrderStatus {
        PROCESSING, IN_DELIVERY, COMPLETED
    }

    public Order(String id, List<Product> products) {
        this(id, products, OrderStatus.PROCESSING, Instant.now());
    }

}
