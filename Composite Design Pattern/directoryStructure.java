import java.util.ArrayList;
import java.util.List;

interface FileSystemComponent{
    void listContents();
    int getSize();
}

class File implements FileSystemComponent{
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void listContents() {
        System.out.println("File: " + name);
    }

    @Override
    public int getSize() {
        return size;
    }
}

class Directory implements FileSystemComponent{
    private String name;
    private List<FileSystemComponent> contents;

    public Directory(String name/*, List<FileSystemComponent> contents*/) {
        this.name = name;
        this.contents = new ArrayList<>();
    }

    public void addComponent(FileSystemComponent component){
        contents.add(component);
    }
    @Override
    public void listContents() {
        System.out.println("Directory: "+name);
        for(FileSystemComponent component: contents){
            component.listContents();
        }
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        for(FileSystemComponent component: contents){
            totalSize += component.getSize();
        }
        return totalSize;
    }
}
public class directoryStructure {
    public static void main(String[] args) {
        Directory root = new Directory("Root");

        FileSystemComponent file1 = new File("Document.txt", 100);
        FileSystemComponent file2 = new File("Image.png", 200);

        Directory subDir = new Directory("subDirectory");
        FileSystemComponent file3 = new File("Data.csv", 150);

        subDir.addComponent(file3);

        root.addComponent(file1);
        root.addComponent(file2);
        root.addComponent(subDir);

        root.listContents();
        int totalSize = root.getSize();
        System.out.println("Total Size: "+ totalSize + " KB");
    }
}
