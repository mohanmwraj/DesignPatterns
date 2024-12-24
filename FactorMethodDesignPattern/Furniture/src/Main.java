interface furniture{
    void display();
}

class Sofa implements furniture{

    @Override
    public void display() {
        System.out.println("Sofa");
    }
}

class Chair implements furniture{

    @Override
    public void display() {
        System.out.println("Chair");
    }
}

interface furnitureFactory{
    furniture createFurniture();
}

class SofaFactory implements furnitureFactory{

    @Override
    public furniture createFurniture() {
        return new Sofa();
    }
}

class ChairFactory implements furnitureFactory{

    @Override
    public furniture createFurniture() {
        return new Chair();
    }
}

public class Main {
    public static void main(String[] args) {

        furnitureFactory sofaFactory = new SofaFactory();
        furniture sofa = sofaFactory.createFurniture();
        sofa.display();

        furnitureFactory chairFactory = new ChairFactory();
        furniture chair = chairFactory.createFurniture();
        chair.display();

    }
}