package utils;

public class Coordinates {
    private int x;
    private int y;

    public Coordinates() {
    }
    public Coordinates(final int newX, final int newY) {
        x = newX;
        y = newY;
    }

    public final void setX(final int x) {
        this.x = x;
    }
    public final void setY(final int y) {
        this.y = y;
    }
    public final int getX() {
        return x;
    }
    public final int getY() {
        return y;
    }
}

