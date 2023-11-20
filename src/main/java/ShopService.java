import lombok.*;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
@Data
@RequiredArgsConstructor
public class ShopService {
    private ProductRepo productRepo = new ProductRepo();
    private OrderRepo orderRepo = new OrderMapRepo();
    private IdService  idService;
    
    private List<Order> orders;

//    public ShopService(ProductRepo orderListRepo, ProductRepo orderListRepo1) {
//    }

//    public ShopService(OrderListRepo orderListRepo, ProductRepo productRepo) {
//    }

    public ShopService(OrderListRepo orderListRepo, ProductRepo productRepo, IdService idService) {
    }

    //    public ShopService() {
//        this.orders = new ArrayList<>();
//    }
    public Order addOrder(List<String> productIds) throws ProductNotFoundException {
        List<Product> products = new ArrayList<>();
        for (String productId : productIds) {
            Product productToOrder = productRepo.getProductById(productId);
            if (productToOrder == null) {
                throw new ProductNotFoundException("Product mit der Id: " + productId + " konnte nicht bestellt werden!");
            }
            products.add(productToOrder);
        }

        //return new Order(UUID.randomUUID().toString(), products, Order.OrderStatus.PROCESSING, Instant.now());

        Order newOrder = new Order(UUID.randomUUID().toString(), products, Order.OrderStatus.PROCESSING, Instant.now());
        orderRepo.addOrder(newOrder);
        
        return newOrder;
    }

    public List<Order> getOrdersByStatus(Order.OrderStatus status) {
        return orders.stream()
                .filter(order -> order.status() == status)
                .collect(Collectors.toList());
    }

    public Order updateOrder(String id, Order.OrderStatus newStatus) {
        Order updateOrder = orders.stream()
                .filter(order -> order.getId().equals(id))
                .findFirst()
                .map(order -> order.withStatus(newStatus))
                .orElse(null);
        if (updateOrder != null) {
            System.out.println("Update");
        }
        return updateOrder;
    }




    public static void main(String[] args) {
        ShopService shopService = new ShopService();

        List<Order> processingOrders = shopService.getOrdersByStatus(Order.OrderStatus.PROCESSING);
        List<Order> inDeliveryOrders = shopService.getOrdersByStatus(Order.OrderStatus.IN_DELIVERY);
        List<Order> completedOrders = shopService.getOrdersByStatus(Order.OrderStatus.COMPLETED);

    }

}
