package generator;

import java.awt.*;
import java.util.Random;

public class RandomGenerator {
    private static Random random = new Random();

    public static float generateFloat() {
        return random.nextFloat();
    }

    public static int generateInt() {
        return random.nextInt(3);
    }

    public static Color generateColor() {
        float r = random.nextFloat();
        float g = random.nextFloat();
        float b = random.nextFloat();

        return new Color(r, g, b);
    }


}


