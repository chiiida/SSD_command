package DrawingBoard.Command;

public interface UndoableCommand {

    public void execute();
    public void undo();
}
