package task3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String json = readString("src/main/resources/new_data.json");
    }

    public static String readString(String jsonWay) {
        String s = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(jsonWay))) {
            while ((s = bufferedReader.readLine()) != null) {
                s = bufferedReader.readLine();
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;

    }
}
