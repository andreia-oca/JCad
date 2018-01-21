package shapes;

import java.awt.Color;

import utils.ColorUtils;
import utils.Coordinates;
import visitor.Drawable;
import visitor.Drawer;

public class Line implements Drawable {
    private Coordinates start = new Coordinates();
    private Coordinates end = new Coordinates();
    private Color color;

    public Line(final int startX, final int startY, final int endX,
            final int endY, final String newColor, final int alpha) {
        start.setX(startX);
        start.setY(startY);
        end.setX(endX);
        end.setY(endY);
        color = ColorUtils.getColor(newColor, alpha);
    }

    public final Coordinates getStart() {
        return start;
    }

    public final Coordinates getEnd() {
        return end;
    }

    public final Color getColor() {
        return color;
    }

    @Override
    public final void accept(final Drawer drawer) {
        drawer.draw(this);
    }

}
