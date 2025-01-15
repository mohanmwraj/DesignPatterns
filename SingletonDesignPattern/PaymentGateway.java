import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class PaymentGateWayManager{
    private PaymentGateWayManager(){
        System.out.println("Payment Gateway Manager Initialized.");
    }

    private static PaymentGateWayManager instance;
    private static Lock mtx = new ReentrantLock();

    public static PaymentGateWayManager getInstance(){
        if(instance == null){ //First check without locking
            mtx.lock(); // Acquire the lock before creating the instance
            try {
                if(instance == null){ // Double-checking locking
                    instance = new PaymentGateWayManager();
                }
            }finally {
                mtx.unlock(); //Always release the lock
            }
        }
        return instance;
    }

    public void processPayment(double amount){
        System.out.println("Processing payment of $" + amount + " through the payment gateway.");
    }
}

public class PaymentGateway {
    public static void main(String[] args) {
        PaymentGateWayManager paymentGateWay = PaymentGateWayManager.getInstance();
        paymentGateWay.processPayment(100.0);

        PaymentGateWayManager anotherPaymentGateway = PaymentGateWayManager.getInstance();

        if(paymentGateWay == anotherPaymentGateway){
            System.out.println("Both Instances are Same. Singleton Pattern is working.");
        } else {
            System.out.println("Singleton Pattern is not working correctly");
        }
    }
}
