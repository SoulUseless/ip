package tasks;

/**
 *  Deadline tasks.Task.
 *
 *  @author Yap Jing Kang
 */


public class DeadlineTask extends Task {
    protected String deadline;

    /**
     *  tasks.DeadlineTask constructor.
     *
     *  @param name Name of tasks.DeadlineTask.
     *  @param deadline Specified deadline of task.
     */
    public DeadlineTask(String name, String deadline) {
        super(name);
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return String.format("[D][%s] %s (by: %s)",
                done == Status.DONE ? "X" : " ",
                name,
                deadline);
    }
}
