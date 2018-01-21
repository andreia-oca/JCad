package shapes;

import java.awt.Color;

import utils.ColorUtils;
import utils.Coordinates;
import visitor.Drawable;
import visitor.Drawer;

public class Diamond implements Drawable {
    private Coordinates center = new Coordinates();
    private int horizontalDiagonal;
    private int verticalDiagonal;
    private Color outerColor;
    private Color innerColor;


    public Diamond(final int x, final int y, final int newHorizontalDiag,
            final int newVerticalDiag, final String oColor, final int oAlpha,
            final String iColor, final int iAlpha) {
        center.setX(x);
        center.setY(y);
        horizontalDiagonal = newHorizontalDiag;
        verticalDiagonal = newVerticalDiag;
        outerColor = ColorUtils.getColor(oColor, oAlpha);
        innerColor = ColorUtils.getColor(iColor, iAlpha);
    }

    public final Coordinates getCenter() {
        return center;
    }

    public final int getHorizontalDiagonal() {
        return horizontalDiagonal;
    }

    public final int getVerticalDiagonal() {
        return verticalDiagonal;
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

    public final Coordinates getNorth() {
        Coordinates north = new Coordinates();
        north.setX(center.getX());
        north.setY(center.getY() + Math.round(verticalDiagonal / 2));
        return north;
    }
    
    public final Coordinates getSouth() {
        Coordinates south = new Coordinates();
        south.setX(center.getX());
        south.setY(center.getY() - Math.round(verticalDiagonal / 2));
        return south;
    }
    
    public final Coordinates getWest() {
        Coordinates west = new Coordinates();
        west.setX(center.getX() - Math.round(horizontalDiagonal / 2));
        west.setY(center.getY());
        return west;
    }
    
    public final Coordinates getEast() {
        Coordinates east = new Coordinates();
        east.setX(center.getX() + Math.round(horizontalDiagonal / 2));
        east.setY(center.getY());
        return east;
    }
}
