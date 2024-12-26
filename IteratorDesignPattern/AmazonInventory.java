import java.util.ArrayList;
import java.util.List;

class Product{
    private String name;
    private String price;

    public Product(String name, String price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}

interface Iterator{
    Product first();
    Product next();
    boolean hasNext();
}

class ProductIterator implements Iterator{
    private List<Product> products;
    private int current;

    public ProductIterator(List<Product> products) {
        this.products = products;
        this.current = 0;
    }

    @Override
    public Product first() {
        if(products.isEmpty()) return null;
        current = 0;
        return products.get(current);
    }

    @Override
    public Product next() {
        if(hasNext()) return products.get(++current);
        return null;
    }

    @Override
    public boolean hasNext() {
        return current < products.size() - 1;
    }
}

class Inventory{
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        products.add(product);
    }

    public Iterator createIterator(){
        return new ProductIterator(products);
    }
}

public class AmazonInventory {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", "9999.99");
        Product product2 = new Product("SmartPhone", "49999.99");
        Product product3 = new Product("HeadPhones", "7999.99");

        Inventory inventory = new Inventory();
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        inventory.addProduct(product3);

        Iterator iterator = inventory.createIterator();
        Product currentProduct = iterator.first();

        while(currentProduct != null){
            System.out.println("Product: " + currentProduct.getName() + ", price: $" + currentProduct.getPrice());
            currentProduct = iterator.next();
        }
    }
}
