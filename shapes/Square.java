package shapes;

import java.awt.Color;

import utils.ColorUtils;
import utils.Coordinates;
import visitor.Drawable;
import visitor.Drawer;

public class Square implements Drawable {

    private Coordinates coordinates = new Coordinates();
    private int length;
    private Color outerColor;
    private Color innerColor;

    public Square(final int x, final int y, final int newLength,
            final String oColor, final int oAlpha, final String iColor, final int iAlpha) {
        coordinates.setY(y);
        coordinates.setX(x);
        length = newLength;
        outerColor = ColorUtils.getColor(oColor, oAlpha);
        innerColor = ColorUtils.getColor(iColor, iAlpha);
    }

    public final Coordinates getCoordinates() {
        return coordinates;
    }

    public final int getLength() {
        return length;
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
