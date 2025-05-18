package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.prinln("===== Delete item =====");
        int id = input.askInt("Enter id: ");
        tracker.delete(id);
        if (tracker.findById(id) == null) {
            out.prinln("Заявка удалена успешно.");
        } else {
            out.prinln("Ошибка удаления заявки.");
        }
        return true;
    }
}
