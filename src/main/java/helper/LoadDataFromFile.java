package helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by trot on 18.02.17.
 */
public class LoadDataFromFile {
    public List<String> load(String fileName) {
        List<String> list = new ArrayList<>();
        InputStream in = getClass().getResourceAsStream("/" + fileName);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            list = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("No such file " + fileName);
        }
        return list;
    }
}
