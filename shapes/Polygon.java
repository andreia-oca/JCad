package shapes;

import java.awt.Color;
import java.util.ArrayList;

import utils.ColorUtils;
import utils.Coordinates;
import visitor.Drawable;
import visitor.Drawer;

public class Polygon implements Drawable {

    private int numberOfVertices;
    private ArrayList<Coordinates> vertices;
    private Color outerColor;
    private Color innerColor;

    public Polygon(final int newNumberOfVertices,
            final ArrayList<Coordinates> newVertices, final String oColor,
            final int oAlpha, final String iColor, final int iAlpha) {
        numberOfVertices = newNumberOfVertices;
        vertices = newVertices;
        outerColor = ColorUtils.getColor(oColor, oAlpha);
        innerColor = ColorUtils.getColor(iColor, iAlpha);
    }

    public final int getNumberOfVertices() {
        return numberOfVertices;
    }

    public final ArrayList<Coordinates> getVertices() {
        return vertices;
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
        int x = 0;
        int y = 0;
        for (int i = 0; i < numberOfVertices; i++) {
            x += vertices.get(i).getX();
            y += vertices.get(i).getY();
        }
        center.setX(Math.round(x / numberOfVertices));
        center.setY(Math.round(y / numberOfVertices));
        return center;
    }
}
