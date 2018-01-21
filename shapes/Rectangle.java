package shapes;

import java.awt.Color;

import utils.ColorUtils;
import utils.Coordinates;
import visitor.Drawable;
import visitor.Drawer;

public class Rectangle implements Drawable {
    private Coordinates coordinates = new Coordinates();
    private int width;
    private int height;
    private Color outerColor;
    private Color innerColor;

    public Rectangle(final int x, final int y, final int newHeight, final int newWidth,
            final String oColor, final int oAlpha, final String iColor, final int iAlpha) {
        coordinates.setX(x);
        coordinates.setY(y);
        width = newWidth;
        height =  newHeight;
        outerColor = ColorUtils.getColor(oColor, oAlpha);
        innerColor = ColorUtils.getColor(iColor, iAlpha);
    }

    public final Coordinates getCoordinates() {
        return coordinates;
    }

    public final int getWidth() {
        return width;
    }

    public final int getHeight() {
        return height;
    }

    public final Color getOuterColor() {
        return outerColor;
    }

    public final Color getInnerColor() {
        return innerColor;
    }

    @Override
    public final void accept(final Drawer drawer) {
        drawer.draw(this);
    }

}
