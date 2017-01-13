package dev.jaakkovirtanen.findandseek.utils;

import java.util.ArrayList;
import java.util.Random;

/**
 * Utility which provides random numbers or array of random numbers.
 *
 */
public class Randomizer {

    private static final Random RANDOM;

    /**
     * init static random.
     */
    static {
        RANDOM = new Random();
    }

    /**
     * Random array of ints factory.
     *
     * @param howManyInts How many ints you want in the array?
     * @param maxVal Max value of individual int
     * @return Array of random integers
     */
    public static ArrayList<Integer> getRandomIntegerArrayList(int howManyInts, int maxVal) {
        ArrayList<Integer> arrayOfIntegers = new ArrayList<>();
        for (int i = 0; i < howManyInts; i++) {
            arrayOfIntegers.add(getRandomNumber(maxVal));
        }
        return arrayOfIntegers;
    }

    /**
     * Gives random integer with given params.
     *
     * @param maxVal Biggest possible, excl 0 incl maxVal
     * @return Random integer
     */
    public static int getRandomNumber(int maxVal) {
        return RANDOM.nextInt(maxVal + 1);
    }

}
