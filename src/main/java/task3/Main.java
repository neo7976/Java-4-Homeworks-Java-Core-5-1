package task3;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import task1.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

        String json = readString("src/main/resources/new_data.json");
        List<Employee> list = jsonToList(json);
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    public static String readString(String jsonWay) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(jsonWay));
        StringBuilder sb = new StringBuilder();
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            sb.append(s);
        }
        bufferedReader.close();
        return sb.toString();
    }

    public static List<Employee> jsonToList(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Employee>>() {
        }.getType();
        return gson.fromJson(json, type);

    }
}
