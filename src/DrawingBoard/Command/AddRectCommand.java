package DrawingBoard.Command;

import DrawingBoard.main.DrawingBoard;
import DrawingBoard.objects.GObject;
import DrawingBoard.objects.Oval;
import DrawingBoard.objects.Rect;

import java.awt.*;

public class AddRectCommand implements UndoableCommand {

    private DrawingBoard drawingBoard = null;
    private GObject gObject = null;

    public AddRectCommand(DrawingBoard drawingBoard, int x, int y, int w, int h, Color color) {
        this.drawingBoard = drawingBoard;
        this.gObject = new Rect(x, y, w, h, color);
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
