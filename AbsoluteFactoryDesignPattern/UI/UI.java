package UI;

import java.util.Scanner;

interface IButton{
    void Press();
}

interface ITextBox{
    void setText();
}

class MacButton implements IButton{

    @Override
    public void Press() {
        System.out.println("Mac Buttong Pressed");
    }
}

class WinButton implements IButton{

    @Override
    public void Press() {
        System.out.println("Windows Button Pressed");
    }
}

class MacTextBox implements ITextBox{

    @Override
    public void setText() {
        System.out.println("Setting text in Mac TextBox");
    }
}

class WinTextBox implements ITextBox{

    @Override
    public void setText() {
        System.out.println("Setting text in Windows TextBox");
    }
}

interface IFactory{
    IButton createButton();
    ITextBox createTextBox();
}

class MacFactory implements IFactory{

    @Override
    public IButton createButton() {
        return new MacButton();
    }

    @Override
    public ITextBox createTextBox() {
        return new MacTextBox();
    }
}

class WinFactory implements IFactory{

    @Override
    public IButton createButton() {
        return new WinButton();
    }

    @Override
    public ITextBox createTextBox() {
        return new WinTextBox();
    }
}

class GUIFactory{
    public static IFactory createFactory(String osType){
        if(osType.equals("windows")){
            return new WinFactory();
        } else if(osType.equals("mac")){
            return new MacFactory();
        }

        return null;
    }
}


public class UI {
    public static void main(String[] args) {
        System.out.println("Enter Machine OS");
        Scanner scanner = new Scanner(System.in);
        String osType = scanner.nextLine();
        scanner.close();

        IFactory factory = GUIFactory.createFactory(osType);

        if(factory != null){
            IButton button = factory.createButton();
            button.Press();

            ITextBox textBox = factory.createTextBox();
            textBox.setText();
        } else {
            System.out.println("Invalid OS Type");
        }
    }
}
