package ui.commands;

import ui.View;

public class AddHuman implements Command {
    private View view;

    public AddHuman(View view){
        this.view = view;
    }


    @Override
    public String getDescription() {
        return "Add a person";
    }

    @Override
    public void execute() {
        view.addHuman();
    }
}