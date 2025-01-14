//Abstraction Layer
interface NavigationImpl{
    void navigateTo(String destination);
}

interface NavigationSystem{
    void navigate(String destination);
}

// Concrete Abstaction: Uber Ride
class UberRide implements NavigationSystem{
    private String driverName;
    private NavigationImpl navigationImpl;

    public UberRide(String driverName){
        this.driverName = driverName;
    }

    public void setNavigationImpl(NavigationImpl impl){
        this.navigationImpl = impl;
    }

    @Override
    public void navigate(String destination) {
        System.out.println("Uber ride with " + driverName + " to " + destination + " using ");
        navigationImpl.navigateTo(destination);
    }
}

// Concrete Abstraction: Uber Eats
class UberEats implements NavigationSystem{
    private String restaurantName;
    private NavigationImpl navigationImpl;

    public UberEats(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public void setNavigationImpl(NavigationImpl impl){
        this.navigationImpl = impl;
    }

    @Override
    public void navigate(String destination) {
        System.out.println("Uber Eats delivery from " + restaurantName + " to " + destination + " using ");
        navigationImpl.navigateTo(destination);
    }
}

// Concrete Implementation: Google Maps
class GoogleMaps implements NavigationImpl{

    @Override
    public void navigateTo(String destination) {
        System.out.println("Google Maps");
        // Actual Navigation logic using Apple Maps API
    }
}

class AppleMaps implements NavigationImpl{

    @Override
    public void navigateTo(String destination) {
        System.out.println("Apple Maps");
        // Actual Navigation logic using Apple MAps API
    }
}

public class UberDemo {
    public static void main(String[] args) {
        //Create a uber ride with a driver
        UberRide uberRide = new UberRide("Mohan");
        //create an uber eats delivery
        UberEats uberEats = new UberEats("Pizza Palace");

        //Create different navigation implementations
        GoogleMaps googleMaps = new GoogleMaps();
        AppleMaps appleMaps = new AppleMaps();

        //set the navigation implementation for uber ride
       // uberEats.setNavigationImpl(googleMaps);
        uberRide.setNavigationImpl(googleMaps);
        // Request an uber ride with Google Maps navigation
        uberRide.navigate("Central Park");

        //Switch to Apple Maps navigation for uber eats
        uberEats.setNavigationImpl(appleMaps);
        //Request an uber eats delivery with Apple Maps navigation
        uberEats.navigate("Fern Hills HSR");
    }
}
