import java.util.ArrayList;
import java.util.List;

interface observer{
    void update(Order order);
}

class Customer implements observer{
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(Order order) {
        System.out.println("Hello, " + name + "! Order #" + order.getId() + " is now " + order.getStatus() + ".");
    }
}

class Restaurant implements observer{
    private String restaurantName;

    public Restaurant(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    @Override
    public void update(Order order) {
        System.out.println("Restaurant "+ restaurantName + " : Order #" + order.getId() + " is now " + order.getStatus() + ".");
    }
}

class DeliveryDriver implements observer{
    private String restaurantName;

    public DeliveryDriver(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    @Override
    public void update(Order order) {
        System.out.println("Restaurant " + restaurantName + ": Order #" + order.getId() + " is now " + order.getStatus() + ".");
    }
}

class CallCenter implements observer{

    @Override
    public void update(Order order) {
        System.out.println("Call center: Order #" + order.getId() + " is now " + order.getStatus() + ".");
    }
}

class Order{
    private int id;
    private String status;
    private List<observer> observerList = new ArrayList<>();

    public Order(int id/*, String status*/) {
        this.id = id;
        this.status = "Order Placed";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }

    public void attach(observer obser){
        observerList.add(obser);
    }

    public void detach(observer ober){
        observerList.remove(ober);
    }

    public void notifyObservers(){
        for(observer ob: observerList){
            ob.update(this);
        }
    }

}
public class OrderStatus {
    public static void main(String[] args) {
        Order order1 = new Order(123);

        Customer customer = new Customer("Customer 1");
        Restaurant restaurant = new Restaurant("Restaurant 1");
        DeliveryDriver driver = new DeliveryDriver("Driver");
        CallCenter callCenter = new CallCenter();

        order1.attach(customer);
        order1.attach(restaurant);
        order1.attach(driver);
        order1.attach(callCenter);

        order1.setStatus("Out for Delivery");
        order1.detach(callCenter);
        order1.setStatus("Delivered");
    }
}
