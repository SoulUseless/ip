package duke.command;

import java.time.LocalDate;

import duke.Storage;
import duke.TaskManager;
import duke.exception.DukeException;

public class EventCommand extends Command {
    private String name;
    private LocalDate date;

    /**
     *  EventCommand constructor.
     *
     *  @param name Name of Event Task.
     *  @param date Date of Event Task.
     */
    public EventCommand(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    /**
     *  Executes EventCommand.
     *
     *  @param tm TaskManager Object from Duke.
     *  @param st Storage Object from Duke.
     *  @return Command response.
     *  @throws DukeException If any error arises from execution.
     */
    public String execute(TaskManager tm, Storage st) throws DukeException {
        tm.addEventTask(name, date);
        st.save(tm);
        String res = String.format("added: %s\n Now you have %d task(s)",
                name,
                tm.getSize());
        return res;
    }
}
