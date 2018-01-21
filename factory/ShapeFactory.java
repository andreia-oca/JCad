package factory;

import java.io.IOException;
import java.util.ArrayList;

import fileio.implementations.FileReader;
import shapes.Canvas;
import shapes.Circle;
import shapes.Diamond;
import shapes.Line;
import shapes.Polygon;
import shapes.Rectangle;
import shapes.Square;
import shapes.Triangle;
import utils.Coordinates;
import visitor.Drawable;

public final class ShapeFactory {
    /*
     * Factory Design Pattern combined with Singleton (one Factory Class needed)
     */
    private static ShapeFactory shapeFactory = new ShapeFactory();

    private ShapeFactory() {
    }

    public static ShapeFactory getShapeFactory() {
        return shapeFactory;
    }

    public Drawable getShape(final String shapeName, final FileReader reader)
            throws IOException {

        if (shapeName.equalsIgnoreCase(ShapeType.CANVAS.toString())) {
            Canvas.initCanvas(reader.nextInt(), reader.nextInt(),
                    reader.nextWord(), reader.nextInt());
            return Canvas.getCanvas();
        }
        if (shapeName.equalsIgnoreCase(ShapeType.LINE.toString())) {
            return new Line(reader.nextInt(), reader.nextInt(),
                    reader.nextInt(), reader.nextInt(), reader.nextWord(),
                    reader.nextInt());
        }
        if (shapeName.equalsIgnoreCase(ShapeType.SQUARE.toString())) {
            return new Square(reader.nextInt(), reader.nextInt(),
                    reader.nextInt(), reader.nextWord(), reader.nextInt(),
                    reader.nextWord(), reader.nextInt());
        }
        if (shapeName.equalsIgnoreCase(ShapeType.RECTANGLE.toString())) {
            return new Rectangle(reader.nextInt(), reader.nextInt(),
                    reader.nextInt(), reader.nextInt(), reader.nextWord(),
                    reader.nextInt(), reader.nextWord(), reader.nextInt());
        }
        if (shapeName.equalsIgnoreCase(ShapeType.CIRCLE.toString())) {
            return new Circle(reader.nextInt(), reader.nextInt(),
                    reader.nextInt(), reader.nextWord(), reader.nextInt(),
                    reader.nextWord(), reader.nextInt());
        }
        if (shapeName.equalsIgnoreCase(ShapeType.TRIANGLE.toString())) {
            return new Triangle(reader.nextInt(), reader.nextInt(),
                    reader.nextInt(), reader.nextInt(), reader.nextInt(),
                    reader.nextInt(), reader.nextWord(), reader.nextInt(),
                    reader.nextWord(), reader.nextInt());
        }
        if (shapeName.equalsIgnoreCase(ShapeType.DIAMOND.toString())) {
            return new Diamond(reader.nextInt(), reader.nextInt(),
                    reader.nextInt(), reader.nextInt(), reader.nextWord(),
                    reader.nextInt(), reader.nextWord(), reader.nextInt());
        }
        if (shapeName.equalsIgnoreCase(ShapeType.POLYGON.toString())) {
            int numberOfVertices = reader.nextInt();
            ArrayList<Coordinates> vertices = new ArrayList<Coordinates>(
                    numberOfVertices);
            for (int i = 0; i < numberOfVertices; i++) {
                Coordinates tmp = new Coordinates(reader.nextInt(), reader.nextInt());
                vertices.add(tmp);
            }
            return new Polygon(numberOfVertices, vertices, reader.nextWord(),
                    reader.nextInt(), reader.nextWord(), reader.nextInt());
        }
        return null;
    }
}
