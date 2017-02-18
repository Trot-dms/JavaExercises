package helper;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


/**
 * Created by trot on 18.02.17.
 */
public class Random {
    public static String getRandomProperty(List<String> propertyList) {
        int size = propertyList.size();
        int randomNum = ThreadLocalRandom.current().nextInt(0, size + 1);
        return propertyList.get(randomNum);
    }

    public static int getRandomNumber(int min, int max) {
        java.util.Random r = new java.util.Random();
        return r.nextInt(max - min + 1) + min;
    }

    public static int getRandomEvenNumber(int min, int max) {
        int number = 0;
        do {
            number = getRandomNumber(min, max);
        } while (number % 2 != 0);
        return number;
    }
}
