package com.canvas;

import com.canvas.common.Command;
import com.canvas.common.PainterEnumFactory;
import com.canvas.common.PainterInput;
import com.canvas.exception.CanvasExceptions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CanvasRunner {

    private final Pattern pattern = Pattern
            .compile("[a-zA-Z]{1}(\\s\\d+)*(\\s[a-zA-z]{1})?+");

    private Command command;

    public static void main(String[] args) throws CanvasExceptions {
        CanvasRunner app = new CanvasRunner();
        try {
            Scanner scanner = new Scanner(System.in);
            do {
                System.out.print("Enter: ");
                app.executeCommnad(scanner.nextLine());
            } while (true);
        } catch (Exception e) {
            throw new CanvasExceptions(e.getMessage());
        }
    }

    private void executeCommnad(final String input)
            throws CanvasExceptions {
        validateCommand(input);
        PainterInput painterInput = new PainterInput(input);
        if (command == null) {
            if (!(painterInput.getPainterEnumFactory().equals(PainterEnumFactory.C) || painterInput
                    .getPainterEnumFactory().equals(PainterEnumFactory.Q))) {
                throw new CanvasExceptions(
                        "Please create canvas first");
            } else {
                command = new Command();
            }
        }

        command.setCommand(painterInput);
        command.executeCommand(painterInput.getParams());
    }

    private void validateCommand(String commandInput)
            throws CanvasExceptions {
        Matcher matcher = pattern.matcher(commandInput);
        if (!matcher.matches()) {
            throw new CanvasExceptions("Command is invalid.");
        }
        String commandPart = commandInput.substring(0, 1);
        PainterEnumFactory.valueOf(commandPart);
    }
}
