abstract class ProductPrototype{
    public abstract ProductPrototype clone();
    public abstract void display();
}

class Product extends ProductPrototype{
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public ProductPrototype clone() {
        return new Product(name, price);
    }

    @Override
    public void display() {
        System.out.println("Product: " + name);
        System.out.println("Price: $"+ price);
    }
}

public class ProductDemo {
    public static void main(String[] args) {
        ProductPrototype product1 = new Product("Laptop", 999.99);
        ProductPrototype product2 = new Product("SmartPhone", 499.99);

        ProductPrototype newProduct1 = product1.clone();
        ProductPrototype newProduct2 = product2.clone();

        System.out.println("Original Products:");
        product1.display();
        product2.display();

        System.out.println("\nCloned Products");
        newProduct1.display();
        newProduct2.display();
    }
}
