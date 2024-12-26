public class Main {
    public static void main(String[] args) {
        DesktopDirector director = new DesktopDirector();

        DellDesktopBuilder dellDesktopBuilder = new DellDesktopBuilder();
        Desktop dellDesktop = director.buildDesktop(dellDesktopBuilder);
        dellDesktop.display();

        HpDesktopBuilder hpDesktopBuilder = new HpDesktopBuilder();
        Desktop hpDesktop = director.buildDesktop(hpDesktopBuilder);
        hpDesktop.display();

    }
}