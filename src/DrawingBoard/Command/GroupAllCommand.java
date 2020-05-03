package DrawingBoard.Command;

import DrawingBoard.main.DrawingBoard;
import DrawingBoard.objects.CompositeGObject;
import DrawingBoard.objects.GObject;

import java.util.ArrayList;
import java.util.List;

public class GroupAllCommand implements UndoableCommand {

    private DrawingBoard drawingBoard = null;
    private List<GObject> gObjects = null;
    private List<GObject> gObjectsCopy = null;

    public GroupAllCommand(DrawingBoard drawingBoard, List<GObject> gObjects) {
        this.drawingBoard = drawingBoard;
        this.gObjects = gObjects;
        this.gObjectsCopy = new ArrayList<GObject>(gObjects);
    }

    @Override
    public void execute() {
        drawingBoard.groupAll();
    }

    @Override
    public void undo() {
        gObjects.clear();
        for (GObject child : gObjectsCopy) {
            drawingBoard.addGObject(child);
        }
    }
}
