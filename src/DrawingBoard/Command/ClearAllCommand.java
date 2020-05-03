package DrawingBoard.Command;

import DrawingBoard.main.DrawingBoard;
import DrawingBoard.objects.GObject;

import java.util.ArrayList;
import java.util.List;

public class ClearAllCommand implements UndoableCommand {

    private DrawingBoard drawingBoard = null;
    private List<GObject> gObjects = null;

    public ClearAllCommand(DrawingBoard drawingBoard, List<GObject> gObjects) {
        this.drawingBoard = drawingBoard;
        this.gObjects = gObjects;
    }

    @Override
    public void execute() {
        List<GObject> gObjectsCopy = new ArrayList<GObject>(gObjects);
        gObjects.clear();
        drawingBoard.repaint();
        gObjects = gObjectsCopy;
    }

    @Override
    public void undo() {
        for (GObject child : gObjects) {
            drawingBoard.addGObject(child);
        }
    }
}
