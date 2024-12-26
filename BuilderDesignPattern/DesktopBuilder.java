class Desktop{

    private String motherBoard;
    private String processor;
    private String memory;
    private String storage;
    private String graphicsCard;

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getMotherBoard() {
        return motherBoard;
    }

    public void setMotherBoard(String motherBoard) {
        this.motherBoard = motherBoard;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public void Display(){
        System.out.println("Desktop Specs");
        System.out.println("Motherboard: "+ motherBoard);
        System.out.println("Processor: "+processor);
        System.out.println("Memory: "+memory);
        System.out.println("Storage: "+storage);
        System.out.println("Graphics Card: "+graphicsCard);
    }
}

abstract class DesktopBuilders{
    protected Desktop desktop = new Desktop();

    public abstract void buildMotherBoard();
    public abstract void buildProcessor();
    public abstract void buildMemory();
    public abstract void buildStorage();
    public abstract void buildGraphicsCard();

    public Desktop getDesktop(){
        return desktop;
    }
}


class DellDesktopBuilder extends DesktopBuilders{

    @Override
    public void buildMotherBoard() {
        desktop.setMotherBoard("Dell Motherboard");
    }

    @Override
    public void buildProcessor() {
        desktop.setProcessor("Dell Processor");
    }

    @Override
    public void buildMemory() {
        desktop.setMemory("32GB DDR4 RAM");
    }

    @Override
    public void buildStorage() {
        desktop.setStorage("1TB SSD + 2TB HDD");
    }

    @Override
    public void buildGraphicsCard() {
        desktop.setGraphicsCard("NVIDIA RTX 9000");
    }
}

class HpDesktopBuilder extends DesktopBuilders{

    @Override
    public void buildMotherBoard() {
        desktop.setMotherBoard("Dell MotherBoard");
    }

    @Override
    public void buildProcessor() {
        desktop.setProcessor("HP Processor");
    }

    @Override
    public void buildMemory() {
        desktop.setMemory("32GB DDR4 RAM");
    }

    @Override
    public void buildStorage() {
        desktop.setStorage("1TB SSD + 2TB HDD");
    }

    @Override
    public void buildGraphicsCard() {
        desktop.setGraphicsCard("NVIDIA RTX 9000");
    }
}

class DesktopDirector{
    public Desktop buildDesktop(DesktopBuilders builder){
        builder.buildMemory();
        builder.buildGraphicsCard();
        builder.buildMotherBoard();
        builder.buildProcessor();
        builder.buildStorage();

        return builder.getDesktop();
    }
}
public class DesktopBuilder {
    public static void main(String[] args) {
        DesktopDirector director = new DesktopDirector();

        DellDesktopBuilder dellDesktopBuilder = new DellDesktopBuilder();
        Desktop dellDesktop = director.buildDesktop(dellDesktopBuilder);

        HpDesktopBuilder hpDesktopBuilder = new HpDesktopBuilder();
        Desktop hpDesktop = director.buildDesktop(hpDesktopBuilder);

        dellDesktop.Display();
        hpDesktop.Display();
    }
}
