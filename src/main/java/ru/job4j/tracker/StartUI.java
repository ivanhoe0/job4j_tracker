package ru.job4j.tracker;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select > actions.length - 1) {
                out.prinln("Wrong input, you can select: 0 .. " + (actions.length - 1));
                continue;
            }
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }

    }

    private void showMenu(UserAction[] actions) {
        out.prinln("Menu:");
        for (int i = 0; i < actions.length; i++) {
            out.prinln(i + ". " + actions[i].name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(new ConsoleInput(), output);
        Tracker tracker = new Tracker();
        UserAction[] actions = {
          new CreateAction(output),
          new ShowAllAction(output),
          new EditAction(output),
          new DeleteAction(output),
          new FindByIdAction(output),
          new FindByNameAction(output),
          new Exit()
        };
        new StartUI(output).init(input, tracker, actions);
    }
}
