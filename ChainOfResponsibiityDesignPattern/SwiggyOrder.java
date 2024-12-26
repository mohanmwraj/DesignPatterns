abstract class OrderHandler{
    protected  OrderHandler nextHandler;

    public OrderHandler(OrderHandler nextHandler){
        this.nextHandler = nextHandler;
    }

    public abstract void processOrder(String order);
}

class OrderValidationHandler extends OrderHandler{

    public OrderValidationHandler(OrderHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void processOrder(String order) {
        System.out.println("Validating Order: "+order);
        if(nextHandler != null) nextHandler.processOrder(order);
    }
}

class PaymentProcessingHandler extends OrderHandler{

    public PaymentProcessingHandler(OrderHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void processOrder(String order) {
        System.out.println("Processing Payment for order: "+order);
        if(nextHandler != null) nextHandler.processOrder(order);
    }
}

class OrderPreparationHandler extends OrderHandler{

    public OrderPreparationHandler(OrderHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void processOrder(String order) {
        System.out.println("Preparing Order: "+order);
        if(nextHandler != null) nextHandler.processOrder(order);
    }
}

class DeliveryAssignmentHandler extends OrderHandler{

    public DeliveryAssignmentHandler(OrderHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void processOrder(String order) {
        System.out.println("Assigning delivery for order: "+order);

        if(nextHandler != null) nextHandler.processOrder(order);
    }
}

class OrderTrackingHandler extends OrderHandler{

    public OrderTrackingHandler(OrderHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void processOrder(String order) {
        System.out.println("Tracking Order: "+order);
    }
}

public class SwiggyOrder {
    public static void main(String[] args) {
        OrderHandler orderProcessingChain = new OrderValidationHandler(
                new PaymentProcessingHandler(
                        new OrderPreparationHandler(
                                new DeliveryAssignmentHandler(
                                        new OrderTrackingHandler(null)
                                ))));

        String order = "Pizza";
        orderProcessingChain.processOrder(order);

    }
}
