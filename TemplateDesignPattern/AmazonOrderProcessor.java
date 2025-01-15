abstract class OrderProcessingTemplate{
    public void processOrder(){
        verifyOrder();
        assignDeliveryAgent();
        trackDelivery();
    }

    protected abstract void trackDelivery();

    protected abstract void assignDeliveryAgent();

    protected abstract void verifyOrder();
}

class LocalOrderProcessor extends OrderProcessingTemplate{

    @Override
    protected void trackDelivery() {
        System.out.println("Verifying the local orders....");
    }

    @Override
    protected void assignDeliveryAgent() {
        System.out.println("Assigning a local delivery agent...");
    }

    @Override
    protected void verifyOrder() {
        System.out.println("Tracking local delivery...");
    }
}

class InternationalOrderProcessor extends OrderProcessingTemplate{

    @Override
    protected void trackDelivery() {
        System.out.println("Verfying the international order...");
    }

    @Override
    protected void assignDeliveryAgent() {
        System.out.println("Assigning an international delivery agent...");
    }

    @Override
    protected void verifyOrder() {
        System.out.println("Tracking international delivery...");
    }
}

public class AmazonOrderProcessor {
    public static void main(String[] args) {
        OrderProcessingTemplate localOrder = new LocalOrderProcessor();
        OrderProcessingTemplate internationalOrder = new InternationalOrderProcessor();

        System.out.println("Processing a local order");
        localOrder.processOrder();
        System.out.println();

        System.out.println("Processing an international order");
        internationalOrder.processOrder();
        System.out.println();
    }
}
