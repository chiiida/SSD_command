package DrawingBoard.Command;

import java.util.Stack;

public class Invoker {
    private Stack<UndoableCommand> pastCommands = new Stack<UndoableCommand>();
    private Stack<UndoableCommand> futureCommands = new Stack<UndoableCommand>();
    private UndoableCommand currentCommand = null;

    public Invoker() { }

    public void setCommand(UndoableCommand command) {
        this.currentCommand = command;
    }

    public void executeCommand() {
        currentCommand.execute();
        pastCommands.push(currentCommand);
        currentCommand = null;
        futureCommands.clear();
    }

    public void undoCommand() {
        if (!pastCommands.empty()) {
            UndoableCommand lastCommand = pastCommands.pop();
            lastCommand.undo();
            futureCommands.push(lastCommand);
        }
    }

    public void redoCommand() {
        if (!futureCommands.empty()) {
            UndoableCommand nextCommand = futureCommands.pop();
            nextCommand.execute();
            pastCommands.push(nextCommand);
        }
    }

}
