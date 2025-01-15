interface PaymentStrategy{
    void processPayment(double amount);
}

class CreditCardPayment implements PaymentStrategy{

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $"+amount);
    }
}

class PayPalPayment implements PaymentStrategy{

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Paypal Payment of $"+amount);
    }
}

class CryptocurrencyPayment implements PaymentStrategy{

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Crypto Currency Payment of $"+amount);
    }
}

class PaymentStrategyFactory{
    public static PaymentStrategy createPaymentStrategy(String paymentMethod){
        if(paymentMethod.equals("CreditCard")){
            return new CreditCardPayment();
        } else if(paymentMethod.equals("PayPal")){
            return new PayPalPayment();
        } else if(paymentMethod.equals("CryptoCurrency")){
            return new CryptocurrencyPayment();
        } else {
            return new CreditCardPayment();
        }
    }
}

class PaymentProcessor{
    private PaymentStrategy paymentStrategy;

    public PaymentProcessor() {
        this.paymentStrategy = null;
    }

    public void setPaymentStrategy(String paymentMethod){
        if(this.paymentStrategy != null){
            paymentStrategy = null;
        }
        paymentStrategy = PaymentStrategyFactory.createPaymentStrategy(paymentMethod);
    }

    public void processPayment(double amount){
        if(paymentStrategy != null){
            paymentStrategy.processPayment(amount);
        } else {
            System.err.println("Payment Strategy not set.");
        }
    }

    public void finialize(){
        if(paymentStrategy != null){
            paymentStrategy = null;
        }
    }
}

public class PaymentDemo {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        processor.setPaymentStrategy("CreditCard");
        processor.processPayment(100.0);

        processor.setPaymentStrategy("PayPal");
        processor.processPayment(50.0);
    }
}
