interface FoodItem{
    String getDescription();
    double getPrice();
}

class Pizza implements FoodItem{

    @Override
    public String getDescription() {
        return "Pizza";
    }

    @Override
    public double getPrice() {
        return 200.0;
    }
}

class Burget implements FoodItem{

    @Override
    public String getDescription() {
        return "Burger";
    }

    @Override
    public double getPrice() {
        return 100.0;
    }
}

abstract class Decorator implements FoodItem{
    protected FoodItem foodItem;

    public Decorator(FoodItem item){
        this.foodItem = item;
    }
}

class ExtraCheeseDecorator extends Decorator{
    private double extraCheesePrice;

    public ExtraCheeseDecorator(FoodItem item, double price){
        super(item);
        this.extraCheesePrice = price;
    }

    @Override
    public String getDescription() {
        return foodItem.getDescription() + " with Extra Cheese";
    }

    @Override
    public double getPrice() {
        return foodItem.getPrice() + extraCheesePrice;
    }
}

class ExtraSauceDecorator extends Decorator{
    private double extraSaucePrice;

    public ExtraSauceDecorator(FoodItem item, double extraSaucePrice) {
        super(item);
        this.extraSaucePrice = extraSaucePrice;
    }

    @Override
    public String getDescription() {
        return foodItem.getDescription() + " with Extra Toppings";
    }

    @Override
    public double getPrice() {
        return foodItem.getPrice() + extraSaucePrice;
    }
}

public class Swiggy {
    public static void main(String[] args) {
        FoodItem pizzaOrder = new Pizza();
        FoodItem burgerOrder = new Burget();

        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder, 10.0);
        pizzaOrder = new ExtraSauceDecorator(pizzaOrder, 5.0);

        burgerOrder = new ExtraSauceDecorator(burgerOrder, 20.0);
        burgerOrder = new ExtraCheeseDecorator(burgerOrder, 10.0);

        System.out.println("Description of pizza order is "+pizzaOrder.getDescription());
        System.out.println("Price of the pizza order is " +pizzaOrder.getPrice());

        System.out.println("Description of burger order is "+burgerOrder.getDescription());
        System.out.println("Price of burger order is: "+burgerOrder.getPrice());
    }
}
