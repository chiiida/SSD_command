package DrawingBoard.Command;

import DrawingBoard.main.DrawingBoard;
import DrawingBoard.objects.GObject;

import java.awt.*;

public class DeleteSelectedCommand implements UndoableCommand {

    private DrawingBoard drawingBoard = null;
    private GObject gObject = null;

    public DeleteSelectedCommand(DrawingBoard drawingBoard, GObject gObject) {
        this.drawingBoard = drawingBoard;
        this.gObject = gObject;
    }

    @Override
    public void execute() {
        drawingBoard.deleteObj(gObject);
    }

    @Override
    public void undo() {
        drawingBoard.addGObject(gObject);
    }
}
