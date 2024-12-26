class RideService{
    public void requestRide(String Passenger, String srcLoc, String desLoc){
        System.out.println("Requesting a ride for Passenger: " + Passenger +
                 " from " + srcLoc + " to " + desLoc);
    }

    public void cancelRide(String Passenger){
        System.out.println("Cancelling the ride for the Passenger: "+Passenger);
    }
}

interface command{
    void execute();
}

class RideRequestCommand implements command{
    private RideService receiver;
    private String passenger;
    private String srcLoc;
    private String desLoc;

    public RideRequestCommand(RideService receiver, String passenger, String srcLoc, String desLoc) {
        this.receiver = receiver;
        this.passenger = passenger;
        this.srcLoc = srcLoc;
        this.desLoc = desLoc;
    }

    @Override
    public void execute() {
        receiver.requestRide(passenger, srcLoc, desLoc);
    }
}

class cancelRideCommand implements command{
    private RideService rideService;
    private String passenger;

    public cancelRideCommand(RideService rideService, String passenger) {
        this.rideService = rideService;
        this.passenger = passenger;
    }

    @Override
    public void execute() {
        rideService.cancelRide(passenger);
    }
}

class RideRequestInvoker{
    public void processResult(command com){
        com.execute();
    }
}

public class UberRidesDemo {
    public static void main(String[] args) {
        RideService rideService = new RideService();
        RideRequestInvoker rideRequestInvoker = new RideRequestInvoker();

        command request1 = new RideRequestCommand(rideService, "Mohan", "Bangalore", "Namakkal");
        command request2 = new RideRequestCommand(rideService, "Mohan", "Bangalore", "Jaipur");
        command cancel1 = new cancelRideCommand(rideService, "Mohan");

        rideRequestInvoker.processResult(request1);
        rideRequestInvoker.processResult(request2);
        rideRequestInvoker.processResult(cancel1);
    }
}
