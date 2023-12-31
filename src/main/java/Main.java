import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Main {


    public static void main(String[] args) {
        // Create instances of OrderRepo and ShopRepo
        OrderListRepo orderListRepo = new OrderListRepo();
        ProductRepo productRepo = new ProductRepo();
        IdService idService = new UuidIdService();

        // Create an instance of ShopService using the constructor generated by @RequiredArgsConstructor
        ShopService shopService = new ShopService(orderListRepo, productRepo, idService);


        // Define three concrete orders
        Order order1 = shopService.addOrder(List.of("1", "2"));
        Order order2 = shopService.addOrder(List.of("3", "4"));
        Order order3 = shopService.addOrder(List.of("5"));


        // Display the orders
        System.out.println("Order 1: " + order1);
        System.out.println("Order 2: " + order2);
        System.out.println("Order 3: " + order3);





//        String fileName = "transactions.txt"; // Update with your actual file name
//        //ShopService shopService = new ShopService(); // Assuming you have a ShopService class
//
//        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                processCommand(line, shopService);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

//    private static void processCommand(String commandLine, ShopService shopService) {
//        String[] parts = commandLine.split("\\s+"); // Split by whitespace
//        String command = parts[0];
//
//        switch (command) {
//            case "addOrder":
//                String orderId = parts[1];
//                List<String> productIds = Arrays.asList(Arrays.copyOfRange(parts, 2, parts.length));
//                shopService.addOrder(orderId, productIds);
//                break;
//            case "setStatus":
//                String orderIdToSetStatus = parts[1];
//                String statusToSet = parts[2];
//                shopService.setStatus(orderIdToSetStatus, statusToSet);
//                break;
//            case "printOrders":
//                shopService.printOrders();
//                break;
//            // Add more cases for other supported commands if needed
//            default:
//                System.out.println("Unsupported command: " + command);
//        }
//    }



}
