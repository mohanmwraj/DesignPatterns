import java.util.ArrayList;
import java.util.List;

interface ActionListenerCommand{
    void execute();
}

class Document{
    public void open(){
        System.out.println("Document Opened");
    }

    public void save(){
        System.out.println("Document Saved");
    }
}

class ActionOpen implements ActionListenerCommand{

    Document doc;

    public ActionOpen(Document doc) {
        this.doc = doc;
    }

    @Override
    public void execute() {
        doc.open();
    }
}

class ActionSave implements ActionListenerCommand{
    Document doc;
    public ActionSave(Document doc) {
        this.doc = doc;
    }

    @Override
    public void execute() {
        doc.save();
    }
}

class MenuOptions{
    private List<ActionListenerCommand> commands = new ArrayList<>();

    public void addCommand(ActionListenerCommand command){
        commands.add(command);
    }

    public void executeCommands(){
        for(ActionListenerCommand command: commands){
            command.execute();
        }
    }
}

public class DocumentDemo {
    public static void main(String[] args) {
        Document doc = new Document();

        ActionListenerCommand clickOpen = new ActionOpen(doc);
        ActionListenerCommand clickSave = new ActionSave(doc);

        MenuOptions menu = new MenuOptions();
        menu.addCommand(clickOpen);
        menu.addCommand(clickSave);

        menu.executeCommands();
    }
}
