package dev.jaakkovirtanen.findandseek.game.utils;

import java.util.ArrayList;
import java.util.Random;

public class Randomizer {

    private static final Random random;

    static {
        random = new Random();
    }

    public static ArrayList<Integer> getRandomIntegerArrayList(int howManyInts, int maxVal) {
        ArrayList<Integer> arrayOfIntegers = new ArrayList<>();
        for (int i = 0; i < howManyInts; i++) {
            arrayOfIntegers.add(getRandomNumber(maxVal));
        }
        return arrayOfIntegers;
    }

    public static int getRandomNumber(int maxVal) {
        return random.nextInt(maxVal + 1);
    }

}
