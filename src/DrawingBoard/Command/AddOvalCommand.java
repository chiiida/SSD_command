package DrawingBoard.Command;

import DrawingBoard.main.DrawingBoard;
import DrawingBoard.objects.GObject;
import DrawingBoard.objects.Oval;

import java.awt.*;

public class AddOvalCommand implements UndoableCommand {

    private DrawingBoard drawingBoard = null;
    private GObject gObject = null;

    public AddOvalCommand(DrawingBoard drawingBoard, int x, int y, int w, int h, Color color) {
        this.drawingBoard = drawingBoard;
        this.gObject = new Oval(x, y, w, h, color);
    }

    @Override
    public void execute() {
        drawingBoard.addGObject(gObject);
    }

    @Override
    public void undo() {
        drawingBoard.deleteObj(gObject);
    }
}
