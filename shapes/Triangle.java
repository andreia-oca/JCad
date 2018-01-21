package shapes;

import java.awt.Color;

import utils.ColorUtils;
import utils.Coordinates;
import visitor.Drawable;
import visitor.Drawer;

public class Triangle implements Drawable {

    private Coordinates a = new Coordinates();
    private Coordinates b = new Coordinates();
    private Coordinates c = new Coordinates();
    private Color outerColor;
    private Color innerColor;

    public Triangle(final int ax, final int ay, final int bx, final int by,
            final int cx, final int cy, final String oColor, final int oAlpha,
            final String iColor, final int iAlpha) {
        a.setX(ax);
        a.setY(ay);
        b.setX(bx);
        b.setY(by);
        c.setX(cx);
        c.setY(cy);
        outerColor = ColorUtils.getColor(oColor, oAlpha);
        innerColor = ColorUtils.getColor(iColor, iAlpha);
    }

    public final Coordinates getA() {
        return a;
    }

    public final Coordinates getB() {
        return b;
    }

    public final Coordinates getC() {
        return c;
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

    public final Coordinates getCenter() {
        Coordinates center = new Coordinates();
        center.setX(Math.round((a.getX() + b.getX() + c.getX()) / 3));
        center.setY(Math.round((a.getY() + b.getY() + c.getY()) / 3));
        return center;
    }
}
