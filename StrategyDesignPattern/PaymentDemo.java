interface PaymentStrategy{
    void processPayment(double amount);
}

class CreditCardPayment implements PaymentStrategy{

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Credit Card Payment of $" + amount);
    }
}

class PaypalPayment implements PaymentStrategy{

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Paypal Payment of $" + amount);
    }
}

class CyptocurrentcyPayment implements PaymentStrategy{

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing cryptocurrentcy payment of $" +amount);
    }
}

class PaymentProcessor{
    private PaymentStrategy paymentStrategy;

    public PaymentProcessor() {
        this.paymentStrategy = null;
    }

    public void setPaymentStrategy(PaymentStrategy strategy){
        if(paymentStrategy != null){
            paymentStrategy = null;
        }

        paymentStrategy = strategy;
    }

    public void processPayment(double amount){
        if(paymentStrategy != null){
            paymentStrategy.processPayment(amount);
        } else {
            System.err.println("Payment Strategy not set");
        }
    }

    /**
     *
     */
/*    public void finalize(){
        if(paymentStrategy != null){
            paymentStrategy = null;
        }
    }*/
}

public class PaymentDemo {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        PaymentStrategy strategy = new CreditCardPayment();
        processor.setPaymentStrategy(strategy);
        processor.processPayment(100.0);

        strategy = new PaypalPayment();
        processor.setPaymentStrategy(strategy);
        processor.processPayment(50.0);
    }
}
