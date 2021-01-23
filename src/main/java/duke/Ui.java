package duke;

import java.util.ArrayList;
import java.util.Scanner;

import duke.task.Task;

public class Ui {
    private Scanner sc;

    public Ui() {
        sc = new Scanner(System.in);
    }

    /**
     * Greeter for duke.Duke
     */
    public void showWelcome() {
        String logo = "     ____        _        \n"
                + "    |  _ \\ _   _| | _____ \n"
                + "    | | | | | | | |/ / _ \\\n"
                + "    | |_| | |_| |   <  __/\n"
                + "    |____/ \\__,_|_|\\_\\___|\n";

        System.out.println("    ---------------------------------------");
        System.out.println(logo);
        System.out.println("    ---------------------------------------");
        System.out.println("    Hello! This is duke.Duke");
        System.out.println("    What can I do for you?");
        System.out.println("    ---------------------------------------");
    }

    public void showByeBye() {
        System.out.println("      Thanks for using me!");
    }

    /**
     * LineBreak for duke.Duke
     */
    public void showLine() {
        System.out.println("    ---------------------------------------");
    }

    public String nextCommand() {
        return sc.nextLine();
    }

    public void println(String s) {
        System.out.println("    " + s);
    }

    public void showError(String message) {
        System.out.println("      Error: " + message);
    }

    public void showTasks(ArrayList<Task> tasks) {
        System.out.println("    Listing all duke.tasks: ");
        for (int i = 0; i < tasks.size(); i++) {
            int num = i + 1;
            System.out.println("     "
                    + num + ": " + tasks.get(i));
        }
    }
}
