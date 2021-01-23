package duke.command;

import duke.Storage;
import duke.TaskManager;
import duke.Ui;
import duke.exception.DukeException;

public class ToDoCommand extends Command {
    private String name;

    /**
     *  ToDoCommand constructor.
     *
     *  @param name Name of ToDo Task.
     */
    public ToDoCommand(String name) {
        this.name = name;
    }

    /**
     *  Executes ToDoCommand.
     *
     *  @param ui Ui Object from Duke.
     *  @param tm TaskManager Object from Duke.
     *  @param st Storage Object from Duke.
     *  @throws DukeException If any error arises from execution.
     */
    public void execute(Ui ui, TaskManager tm, Storage st) throws DukeException {
        tm.addToDoTask(name);
        st.save(tm);

        ui.println("    added: " + name);
        ui.println(String.format("    Now you have %d task(s)",
                tm.getSize()));
    }
}
