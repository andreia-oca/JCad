package visitor;

import shapes.Canvas;
import shapes.Circle;
import shapes.Diamond;
import shapes.Line;
import shapes.Polygon;
import shapes.Rectangle;
import shapes.Square;
import shapes.Triangle;

public interface Drawer {
    void draw(Canvas canvas);

    void draw(Line line);

    void draw(Square square);

    void draw(Rectangle rectangle);

    void draw(Circle circle);

    void draw(Triangle triangle);

    void draw(Diamond diamond);

    void draw(Polygon polygon);
}
