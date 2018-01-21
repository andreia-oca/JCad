package visitor;

import shapes.Canvas;
import shapes.Circle;
import shapes.Diamond;
import shapes.Line;
import shapes.Polygon;
import shapes.Rectangle;
import shapes.Square;
import shapes.Triangle;
import utils.DrawFunctions;

public class Draw implements Drawer {

    /**
     * Draw Canvas
     */
    @Override
    public void draw(final Canvas canvas) {
        for (int i = 0; i < Canvas.getWidth(); i++) {
            for (int j = 0; j < Canvas.getHeight(); j++) {
                Canvas.getImage().setRGB(i, j, Canvas.getColor().getRGB());
            }
        }
    }
    /**
     * Draw line
     * Bresenham Algorithm in utils/DrawFunctions.java
     */
    @Override
    public void draw(final Line line) {
        DrawFunctions.drawLine(line.getStart(), line.getEnd(), line.getColor());
    }
    /**
     * Draw square
     */
    @Override
    public void draw(final Square square) {
        DrawFunctions.drawSquare(square);
    }
    /**
     * Draw rectangle
     */
    @Override
    public void draw(final Rectangle rectangle) {
        DrawFunctions.drawRectangle(rectangle);
    }
    /**
     * Draw circle (using flood fill utils/DrawFunctions)
     */
    @Override
    public void draw(final Circle circle) {
        DrawFunctions.drawCircle(circle);
    }
    /**
     * Draw triangle
     */
    @Override
    public void draw(final Triangle triangle) {
        DrawFunctions.drawTriangle(triangle);
    }
    /**
     * Draw Diamond
     */
    @Override
    public void draw(final Diamond diamond) {
        DrawFunctions.drawDiamond(diamond);
    }
    /**
     * Draw polygon
     */
    @Override
    public void draw(final Polygon polygon) {
        DrawFunctions.drawPolygon(polygon);
    }
}
