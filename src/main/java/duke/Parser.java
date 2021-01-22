package duke;

import commands.*;
import exceptions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Parser {
    public static String[] acceptedCommands = {
            "todo", "deadline", "event", "bye", "list", "done", "delete"
    };

    public static void verifyCommand(String c) throws DukeUnknownCommandException {
        boolean found = false;
        for (String cmd : acceptedCommands) {
            if (c.equals(cmd)) {
                found = true;
                break;
            }
        }
        if (!found) {
            throw new DukeUnknownCommandException();
        }
    }

    public static LocalDate processDate(String dateString) throws DukeInvalidDateFormatException {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
            return LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            throw new DukeInvalidDateFormatException();
        }
    }

    public static String[] extractFlag (String c, String s, String flag) throws DukeMissingFlagException {
        String[] output = s.split(" " + flag + " ");
        if (output.length < 2) {
            throw new DukeMissingFlagException(c, flag);
        }
        return output;
    }

    public static Command parse(String c) throws DukeException {
        String[] params = c.strip().split(" ", 2);

        //command integrity verification
        verifyCommand(params[0]);

        //zero-param commands
        if (params[0].equals("bye")) {
            return new ExitCommand();
        } else if (params[0].equals("list")) {
            return new ListCommand();
        }

        //command integrity verification - parameter check
        if (params.length < 2) {
            throw new DukeInsufficientParametersException(params[0]);
        }

        //non-zero-param commands
        try {
            String[] args;
            LocalDate date;

            switch (params[0]) {
                case "done":
                    return new DoneCommand(Integer.parseInt(params[1]));
                case "delete":
                    return new DeleteCommand(Integer.parseInt(params[1]));
                case "todo":
                    return new ToDoCommand(params[1]);
                case "deadline":
                    args = extractFlag(params[0], params[1], "/by");
                    date = processDate(args[1]);
                    return new DeadlineCommand(args[0], date);
                case "event":
                    args = extractFlag(params[0], params[1], "/at");
                    date = processDate(args[1]);
                    return new EventCommand(args[0], date);
            }
        } catch (DukeException e) {
            throw e;
        } catch (Exception e) {
            throw new DukeInvalidParametersException();
        }
        throw new DukeUnknownCommandException();
    }

}
