package task3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import task1.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

        String json = readString("src/main/resources/new_data.json");
        System.out.println(json);
//        List<Employee> list = jsonList(json);

    }

    public static String readString(String jsonWay) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(jsonWay));
        String s;

        while ((s = bufferedReader.readLine()) != null) {


        }

        return null;

    }

    public static List<Employee> jsonList(String json) {
        List<Employee> employees = new ArrayList<>();

        try {
            JSONParser parser = new JSONParser();

            Object[] jsonArray = new Object[]{
                    parser.parse(json)
            };

            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();
            for (Object o : jsonArray) {
                Employee employee = gson.fromJson(json, Employee.class);
                employees.add(employee);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return employees;
    }


}
