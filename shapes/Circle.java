package shapes;

import java.awt.Color;

import utils.ColorUtils;
import utils.Coordinates;
import visitor.Drawable;
import visitor.Drawer;

public class Circle implements Drawable {
    private Coordinates center = new Coordinates();
    private int radius;
    private Color outerColor;
    private Color innerColor;

    /**
     * Constructors coordinates (x, y) with a set radius, an inner and outer color and a given transparency
     */
    public Circle(final int x, final int y, final int newRadius,
            final String oColor, final int oAlpha, final String iColor,
            final int iAlpha) {
        center.setX(x);
        center.setY(y);
        radius = newRadius;
        outerColor = ColorUtils.getColor(oColor, oAlpha);
        innerColor = ColorUtils.getColor(iColor, iAlpha);
    }
    /**
     * 
     * @return The coordinates of the center of the circle
     */
    public final Coordinates getCenter() {
        return center;
    }
    /**
     * 
     * @return The radius of the center
     */
    public final int getRadius() {
        return radius;
    }
    /**
     * 
     * @return The outer color of the circle
     */
    public final Color getOuterColor() {
        return outerColor;
    }
    /**
     * 
     * @return The inner color of the circle
     */
    public final Color getInnerColor() {
        return innerColor;
    }

    @Override
    public final void accept(final Drawer drawer) {
        drawer.draw(this);
    }

}
