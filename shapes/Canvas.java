package shapes;

import java.awt.Color;
import java.awt.image.BufferedImage;

import utils.ColorUtils;
import visitor.Drawable;
import visitor.Drawer;

public final class Canvas implements Drawable {
    /*
     * Singleton Design Pattern => only one Canvas
     */
    private static BufferedImage image;
    private static Color color;
    private static int height;
    private static int width;
    private static Canvas canvas = new Canvas();

    /*
     * Canvas Constructor
     */
    private Canvas() {
    }

    /**
     * 
     * @return the reference to the only canvas object (Singleton pattern)
     */
    public static Canvas getCanvas() {
        return canvas;
    }
    /**
     * 
     * @return reference toBufferedImage image
     */
    public static BufferedImage getImage() {
        return image;
    }
    /**
     * 
     * @return Background color 
     */
    public static Color getColor() {
        return color;
    }
    /**
     * 
     * @return height of canvas
     */
    public static int getHeight() {
        return height;
    }

    /**
     * 
     * @return width of canvas
     */
    public static int getWidth() {
        return width;
    }

    /**
     * Canvas Initialization
     * Sets width, height, color for the canvas
     */
    public static void initCanvas(final int newHeight, final int newWidth,
            final String newColor, final int alpha) {
        height = newHeight;
        width = newWidth;
        color = ColorUtils.getColor(newColor, alpha);
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }

    @Override
    public void accept(final Drawer drawer) {
        drawer.draw(this);
    }
}
