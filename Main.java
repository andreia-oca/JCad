import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import factory.ShapeFactory;
import fileio.implementations.FileReader;
import shapes.Canvas;
import visitor.Draw;
import visitor.Drawable;
import visitor.Drawer;

/**
 * @author Ocanoaia Andreia Irina
 */
public final class Main {
    private Main() {
    }

    public static void main(final String[] args) throws IOException {
        String inputFile = args[0];
        FileReader reader = new FileReader(inputFile);

        int numberOfShapes = reader.nextInt();
        ArrayList<Drawable> shapes = new ArrayList<Drawable>(numberOfShapes);
        String objectType = "";

        /*
         * Using Factory to read and create shapes
         */
        ShapeFactory shapeFactory = ShapeFactory.getShapeFactory();
        for (int i = 0; i < numberOfShapes; i++) {
            objectType = reader.nextWord();
            shapes.add(shapeFactory.getShape(objectType, reader));
        }
        reader.close();

        /*
         * Draw shapes (visitor design pattern)
         */
        BufferedImage image = Canvas.getImage();
        Drawer draw = new Draw();

        for (Drawable s : shapes) {
            s.accept(draw);
        }

        /*
         * Write to image.png
         */
        String output = "drawing.png";
        File outputFile = new File(output);
        try {
            ImageIO.write(image, "PNG", outputFile);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
