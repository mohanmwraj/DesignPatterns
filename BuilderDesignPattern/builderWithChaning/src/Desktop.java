public class Desktop {
    String motherBoard;
    String processor;
    String memory;
    String storage;
    String graphicsCard;

    public void display() {
        System.out.println("Desktop Specs:");
        System.out.println("Motherboard: " + motherBoard);
        System.out.println("Processor: " + processor);
        System.out.println("Memory: " + memory);
        System.out.println("Storage: " + storage);
        System.out.println("Graphics Card:" + graphicsCard);
    }
}

abstract class DesktopBuilder{
    protected Desktop desktop;

    abstract DesktopBuilder buildMotherBoard();
    abstract DesktopBuilder buildProcessor();
    abstract DesktopBuilder buildMemory();
    abstract DesktopBuilder buildStorage();
    abstract DesktopBuilder buildGraphicsCard();

    Desktop build(){
        return desktop;
    }
}

class DellDesktopBuilder extends DesktopBuilder{
    DellDesktopBuilder(){
        desktop = new Desktop();
    }
    @Override
    DesktopBuilder buildMotherBoard() {
        desktop.motherBoard = "Dell MotherBoard";
        return this;
    }

    @Override
    DesktopBuilder buildProcessor() {
        desktop.processor = "Dell Processor";
        return this;
    }

    @Override
    DesktopBuilder buildMemory() {
        desktop.memory = "32GB DDR4 RAM";
        return this;
    }

    @Override
    DesktopBuilder buildStorage() {
        desktop.storage = "1TB SSD + 2TB HDD";
        return this;
    }

    @Override
    DesktopBuilder buildGraphicsCard() {
        desktop.graphicsCard = "NVIDIA RTX 3080";
        return this;
    }
}

class HpDesktopBuilder extends DesktopBuilder{

    HpDesktopBuilder(){
        desktop = new Desktop();
    }
    @Override
    DesktopBuilder buildMotherBoard() {
        desktop.motherBoard = "Hp MotherBoard";
        return this;
    }

    @Override
    DesktopBuilder buildProcessor() {
        desktop.processor = "HP Processor";
        return this;
    }

    @Override
    DesktopBuilder buildMemory() {
        desktop.memory = "32 GB DDR4 RAM";
        return this;
    }

    @Override
    DesktopBuilder buildStorage() {
        desktop.storage = "1TB SSD + 2TB HDD";
        return this;
    }

    @Override
    DesktopBuilder buildGraphicsCard() {
        desktop.graphicsCard = "NVIDIA RTX 3080";
        return this;
    }
}

class DesktopDirector{
    Desktop buildDesktop(DesktopBuilder builder){
        return builder.buildMotherBoard().buildProcessor().buildMemory().buildStorage().buildGraphicsCard().build();
    }
}
