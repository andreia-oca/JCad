package utils;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

import shapes.Canvas;
import shapes.Circle;
import shapes.Diamond;
import shapes.Polygon;
import shapes.Rectangle;
import shapes.Square;
import shapes.Triangle;

public final class DrawFunctions {
    private DrawFunctions() {
    }
    /*
     * Auxiliary methods
     */
    private static int sign(final int a) {
        if (a > 0) {
            return 1;
        }
        if (a < 0) {
            return -1;
        }
        return 0;
    }

    /*
     * Checking if pixel(x,y) is within canvas borders
     */
    private static boolean isWithinShape(final int x, final int y) {
        if (x < Canvas.getWidth() && y < Canvas.getHeight() && x >= 0
                && y >= 0) {
            return true;
        }
        return false;
    }

    /*
     * Draw a line with Brehensen algorithm
     */
    public static void drawLine(final Coordinates start, final Coordinates end,
            final Color color) {
        // Initialize variables
        int x = start.getX();
        int y = start.getY();
        int deltaX = Math.abs(end.getX() - start.getX());
        int deltaY = Math.abs(end.getY() - start.getY());
        int s1 = sign(end.getX() - start.getX());
        int s2 = sign(end.getY() - start.getY());

        boolean flagInterchanged = false;
        int tmp;
        if (deltaY > deltaX) {
            // swap deltaX, deltaY
            tmp = deltaY;
            deltaY = deltaX;
            deltaX = tmp;
            flagInterchanged = true;
        } else {
            flagInterchanged = false;
        }

        int error = 2 * deltaY - deltaX;
        for (int i = 0; i <= deltaX; i++) {
            if (isWithinShape(x, y)) {
                Canvas.getImage().setRGB(x, y, color.getRGB());
            }
            while (error > 0) {
                if (flagInterchanged) {
                    x += s1;
                } else {
                    y += s2;
                }
                error = error - 2 * deltaX;
            }
            if (flagInterchanged) {
                y += s2;
            } else {
                x += s1;
            }
            error = error + 2 * deltaY;
        }
    }

    public static void drawLine(final int startX, final int startY,
            final int endX, final int endY, final Color color) {
        Coordinates start = new Coordinates(startX, startY);
        Coordinates end = new Coordinates(endX, endY);
        drawLine(start, end, color);
    }

    public static void drawRectangle(final Rectangle rectangle) {
        Coordinates start = rectangle.getCoordinates();
        /*
         * Inner color
         */
        for (int x = start.getX(); x < start.getX()
                + rectangle.getWidth(); x++) {
            for (int y = start.getY(); y < start.getY()
                    + rectangle.getHeight(); y++) {
                if (isWithinShape(x, y)) {
                    Canvas.getImage().setRGB(x, y,
                            rectangle.getInnerColor().getRGB());
                }
            }
        }
        /*
         * Outer color
         */
        DrawFunctions.drawLine(start.getX(), start.getY(),
                start.getX() + rectangle.getWidth() - 1, start.getY(),
                rectangle.getOuterColor());

        DrawFunctions.drawLine(start.getX() + rectangle.getWidth() - 1,
                start.getY(), start.getX() + rectangle.getWidth() - 1,
                start.getY() + rectangle.getHeight() - 1,
                rectangle.getOuterColor());

        DrawFunctions.drawLine(start.getX() + rectangle.getWidth() - 1,
                start.getY() + rectangle.getHeight() - 1, start.getX(),
                start.getY() + rectangle.getHeight() - 1,
                rectangle.getOuterColor());

        DrawFunctions.drawLine(start.getX(),
                start.getY() + rectangle.getHeight() - 1, start.getX(),
                start.getY(), rectangle.getOuterColor());
    }

    public static void drawSquare(final Square square) {
        Coordinates start = square.getCoordinates();
        /*
         * Inner color
         */
        for (int x = start.getX(); x < start.getX() + square.getLength(); x++) {
            for (int y = start.getY(); y < start.getY()
                    + square.getLength(); y++) {
                if (isWithinShape(x, y)) {
                    Canvas.getImage().setRGB(x, y,
                            square.getInnerColor().getRGB());
                }
            }
        }
        /*
         * Outer color
         */
        DrawFunctions.drawLine(start.getX(), start.getY(),
                start.getX() + square.getLength() - 1, start.getY(),
                square.getOuterColor());
        DrawFunctions.drawLine(start.getX() + square.getLength() - 1,
                start.getY(), start.getX() + square.getLength() - 1,
                start.getY() + square.getLength() - 1, square.getOuterColor());
        DrawFunctions.drawLine(start.getX() + square.getLength() - 1,
                start.getY() + square.getLength() - 1, start.getX(),
                start.getY() + square.getLength() - 1, square.getOuterColor());

        DrawFunctions.drawLine(start.getX(),
                start.getY() + square.getLength() - 1, start.getX(),
                start.getY(), square.getOuterColor());
    }

    public static void drawCircle(final Circle circle) {
        /*
         * Draw outer line
         */
        int p = 0;
        int q = circle.getRadius();
        int d = 3 - 2 * circle.getRadius();
        while (q > p) {
            auxDrawCircle(circle, circle.getCenter().getX(),
                    circle.getCenter().getY(), p, q);
            p++;
            if (d < 0) {
                d = d + 4 * p + 6;
            } else {
                q--;
                d = d + 4 * (p - q) + 10;
            }
            auxDrawCircle(circle, circle.getCenter().getX(),
                    circle.getCenter().getY(), p, q);
        }
        /*
         * Flood fill
         */
        floodFill(Canvas.getImage(), circle.getCenter(), circle.getOuterColor(),
                circle.getInnerColor());
    }

    private static void auxDrawCircle(final Circle circle, final int xCenter,
            final int yCenter, final int p, final int q) {
        if (isWithinShape(xCenter + p, yCenter + q)) {
            Canvas.getImage().setRGB(xCenter + p, yCenter + q,
                    circle.getOuterColor().getRGB());
        }
        if (isWithinShape(xCenter - p, yCenter + q)) {
            Canvas.getImage().setRGB(xCenter - p, yCenter + q,
                    circle.getOuterColor().getRGB());
        }
        if (isWithinShape(xCenter + p, yCenter - q)) {
            Canvas.getImage().setRGB(xCenter + p, yCenter - q,
                    circle.getOuterColor().getRGB());
        }
        if (isWithinShape(xCenter - p, yCenter - q)) {
            Canvas.getImage().setRGB(xCenter - p, yCenter - q,
                    circle.getOuterColor().getRGB());
        }
        if (isWithinShape(xCenter + q, yCenter + p)) {
            Canvas.getImage().setRGB(xCenter + q, yCenter + p,
                    circle.getOuterColor().getRGB());
        }
        if (isWithinShape(xCenter - q, yCenter + p)) {
            Canvas.getImage().setRGB(xCenter - q, yCenter + p,
                    circle.getOuterColor().getRGB());
        }
        if (isWithinShape(xCenter + q, yCenter - p)) {
            Canvas.getImage().setRGB(xCenter + q, yCenter - p,
                    circle.getOuterColor().getRGB());
        }
        if (isWithinShape(xCenter - q, yCenter - p)) {
            Canvas.getImage().setRGB(xCenter - q, yCenter - p,
                    circle.getOuterColor().getRGB());
        }
    }

    public static void drawTriangle(final Triangle triangle) {
        /*
         * Draw outer line
         */
        DrawFunctions.drawLine(triangle.getA(), triangle.getB(),
                triangle.getOuterColor());
        DrawFunctions.drawLine(triangle.getB(), triangle.getC(),
                triangle.getOuterColor());
        DrawFunctions.drawLine(triangle.getC(), triangle.getA(),
                triangle.getOuterColor());
        /*
         * Flood fill
         */
        floodFill(Canvas.getImage(), triangle.getCenter(),
                triangle.getOuterColor(), triangle.getInnerColor());
    }

    public static void drawDiamond(final Diamond diamond) {
        /*
         * Draw outer line
         */
        DrawFunctions.drawLine(diamond.getNorth(), diamond.getEast(),
                diamond.getOuterColor());
        DrawFunctions.drawLine(diamond.getEast(), diamond.getSouth(),
                diamond.getOuterColor());
        DrawFunctions.drawLine(diamond.getSouth(), diamond.getWest(),
                diamond.getOuterColor());
        DrawFunctions.drawLine(diamond.getWest(), diamond.getNorth(),
                diamond.getOuterColor());
        /*
         * Flood fill
         */
        floodFill(Canvas.getImage(), diamond.getCenter(),
                diamond.getOuterColor(), diamond.getInnerColor());
    }

    public static void drawPolygon(final Polygon polygon) {
        /*
         * Draw outer line
         */
        for (int i = 0; i < polygon.getNumberOfVertices() - 1; i++) {
            DrawFunctions.drawLine(polygon.getVertices().get(i),
                    polygon.getVertices().get(i + 1), polygon.getOuterColor());
        }
        DrawFunctions.drawLine(
                polygon.getVertices().get(polygon.getNumberOfVertices() - 1),
                polygon.getVertices().get(0), polygon.getOuterColor());
        /*
         * Flood fill
         */
        floodFill(Canvas.getImage(), polygon.getCenter(),
                polygon.getOuterColor(), polygon.getInnerColor());
    }

    private static void floodFill(final BufferedImage image,
            final Coordinates center, final Color target,
            final Color replacement) {

        Queue<Coordinates> q = new LinkedList<Coordinates>();

        Canvas.getImage().setRGB(center.getX(), center.getY(),
                replacement.getRGB());

        q.add(center);

        while (!q.isEmpty()) {
            Coordinates tmp = q.remove();
            // System.out.println(tmp.getX() + " " + tmp.getY());
            // West
            if (isWithinShape(tmp.getX() - 1, tmp.getY())) {
                if (Canvas.getImage().getRGB(tmp.getX() - 1,
                        tmp.getY()) != target.getRGB()
                        && Canvas.getImage().getRGB(tmp.getX() - 1,
                                tmp.getY()) != replacement.getRGB()) {
                    Canvas.getImage().setRGB(tmp.getX() - 1, tmp.getY(),
                            replacement.getRGB());
                    q.add(new Coordinates(tmp.getX() - 1, tmp.getY()));
                }
            }
            // East
            if (isWithinShape(tmp.getX() + 1, tmp.getY())) {
                if (Canvas.getImage().getRGB(tmp.getX() + 1,
                        tmp.getY()) != target.getRGB()
                        && Canvas.getImage().getRGB(tmp.getX() + 1,
                                tmp.getY()) != replacement.getRGB()) {
                    Canvas.getImage().setRGB(tmp.getX() + 1, tmp.getY(),
                            replacement.getRGB());
                    q.add(new Coordinates(tmp.getX() + 1, tmp.getY()));
                }
            }
            // North
            if (isWithinShape(tmp.getX(), tmp.getY() + 1)) {
                if (Canvas.getImage().getRGB(tmp.getX(),
                        tmp.getY() + 1) != target.getRGB()
                        && Canvas.getImage().getRGB(tmp.getX(),
                                tmp.getY() + 1) != replacement.getRGB()) {
                    Canvas.getImage().setRGB(tmp.getX(), tmp.getY() + 1,
                            replacement.getRGB());
                    q.add(new Coordinates(tmp.getX(), tmp.getY() + 1));
                }
            }
            // South
            if (isWithinShape(tmp.getX(), tmp.getY() - 1)) {
                if (Canvas.getImage().getRGB(tmp.getX(),
                        tmp.getY() - 1) != target.getRGB()
                        && Canvas.getImage().getRGB(tmp.getX(),
                                tmp.getY() - 1) != replacement.getRGB()) {
                    Canvas.getImage().setRGB(tmp.getX(), tmp.getY() - 1,
                            replacement.getRGB());
                    q.add(new Coordinates(tmp.getX(), tmp.getY() - 1));
                }
            }
        }
    }
}
