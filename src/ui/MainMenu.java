package ui;

import ui.commands.AddHuman;
import ui.commands.Command;
import ui.commands.GetInfo;
import ui.commands.Stop;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;
    private View view;

    public MainMenu(View view){
        this.view = view;
        commandList = new ArrayList<>();
        commandList.add(new AddHuman(view));
        commandList.add(new GetInfo(view));
        commandList.add(new Stop(view));
    }

    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }

    public void execute(int numCommand){
        commandList.get(numCommand - 1).execute();
    }

    public int size(){
        return commandList.size();
    }
}