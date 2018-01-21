package utils;

import java.awt.Color;

public final class ColorUtils {
    private ColorUtils() {
    }
    public static Color getColor(final String stringColor, final int alpha) {
        Color color;
        color = Color.decode(stringColor);
        color = new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha);
        return color;
    }
}
