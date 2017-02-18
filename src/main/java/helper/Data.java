package helper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by trot on 18.02.17.
 */
public class Data {

    private static final String FEMALE_NAMES = "im_f.txt";
    private static final String MALE_NAMES = "im_m.txt";
    private static final String CITIES = "miasta.txt";
    private static final String LAST_NAMES = "nazwiska.txt";
    private static final String STREET_NAMES = "ulice.txt";

    private static List<String> femaleNames = new ArrayList<>();
    private static List<String> maleNames = new ArrayList<>();
    private static List<String> cities = new ArrayList<>();
    private static List<String> lastNames = new ArrayList<>();
    private static List<String> streetNames = new ArrayList<>();

    static {
        LoadDataFromFile data = new LoadDataFromFile();
        femaleNames = data.load(FEMALE_NAMES);
        maleNames = data.load(MALE_NAMES);
        cities = data.load(CITIES);
        lastNames = data.load(LAST_NAMES);
        streetNames = data.load(STREET_NAMES);
    }

    public static List<String> getFemaleNames() {
        return femaleNames;
    }

    public static List<String> getMaleNames() {
        return maleNames;
    }

    public static List<String> getCities() {
        return cities;
    }

    public static List<String> getLastNames() {
        return lastNames;
    }

    public static List<String> getStreetNames() {
        return streetNames;
    }
}
