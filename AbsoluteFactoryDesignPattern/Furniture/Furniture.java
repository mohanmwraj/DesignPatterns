package Furniture;

interface sofa{
    void sitOn();
}

interface chair{
    void sitOn();
}

interface table{
    void place();
}

class ModernSofa implements sofa{

    @Override
    public void sitOn() {
        System.out.println("Sitting on Modern Sofa");
    }
}

class ModernChair implements chair{

    @Override
    public void sitOn() {
        System.out.println("Sitting on a modern chair");
    }
}

class ModernTable implements table{

    @Override
    public void place() {
        System.out.println("Placing items on Modern Table");
    }
}

class TraditionalSofa implements sofa{

    @Override
    public void sitOn() {
        System.out.println("Sitting on Traditional Sofa");
    }
}

class TraditionalChair implements chair{

    @Override
    public void sitOn() {
        System.out.println("Sitting on Traditional Chair");
    }
}

class TraditionalTable implements table{

    @Override
    public void place() {
        System.out.println("Placing Items on Traditional Table");
    }
}

interface furnitureFactory{
    sofa createSofa();
    chair createChair();
    table createTable();

    public static furnitureFactory createFurnitureFactory(String type){
        if(type.equals("modern")){
            return new ModernFurnitureFactory();
        } else if(type.equals("traditional")){
            return new TraditionalFurnitureFactory();
        } else {
            return null;
        }
    }

}

class ModernFurnitureFactory implements furnitureFactory{

    @Override
    public sofa createSofa() {
        return new ModernSofa();
    }

    @Override
    public chair createChair() {
        return new ModernChair();
    }

    @Override
    public table createTable() {
        return new ModernTable();
    }
}

class TraditionalFurnitureFactory implements furnitureFactory{

    @Override
    public sofa createSofa() {
        return new TraditionalSofa();
    }

    @Override
    public chair createChair() {
        return new TraditionalChair();
    }

    @Override
    public table createTable() {
        return new TraditionalTable();
    }
}

public class Furniture {
    public static void main(String[] args) {
        furnitureFactory mf = furnitureFactory.createFurnitureFactory("modern");

        sofa modernSofa = mf.createSofa();
        chair modernChair = mf.createChair();
        table modernTable = mf.createTable();

        modernSofa.sitOn();;
        modernChair.sitOn();;
        modernTable.place();

        furnitureFactory tf = furnitureFactory.createFurnitureFactory("traditional");

        sofa traditionalSofa = tf.createSofa();
        chair traditionalChair = tf.createChair();
        table  traditionalTable = tf.createTable();

        traditionalSofa.sitOn();;
        traditionalChair.sitOn();
        traditionalTable.place();


    }
}
