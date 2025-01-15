interface Image{
    void display();
}

class RealImage implements Image{
    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk();
    }

    @Override
    public void display() {
        System.out.println("Displaying image: "+fileName);
    }

    private void loadFromDisk(){
        System.out.println("Loading image from Disk: "+fileName);
    }
}

class ImageProxy implements Image{
    private RealImage realImage;
    private String fileName;

    public ImageProxy(String fileName){
        this.fileName = fileName;
        this.realImage = null;
    }

    @Override
    public void display() {
        if(realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}

public class imageDemo {
    public static void main(String[] args) {
        Image proxy = new ImageProxy("high_res_image.jpg");
        proxy.display();
        proxy.display();
    }
}
