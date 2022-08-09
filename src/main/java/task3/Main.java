package task3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import task1.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        String json = readString("src/main/resources/new_data.json");
        System.out.println(json);
        List<Employee> list = jsonList(json);


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

    public static List<Employee> jsonList(String json) throws IOException, ParseException {
        List<Employee> employees = new ArrayList<>();
        JSONParser parser = new JSONParser();

//
//
        Object obj = parser.parse(json);


        String data = "[{\"userName\": \"sandeep\",\"age\":30}]  ";
//        JsonArray jsonArray = new JsonArray();
//
//        jsonArray.add(data);
//

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
//        for (Object o : jsonArray) {
//            Employee employee = gson.fromJson(json, Employee.class);
//            System.out.println(employee);
//            employees.add(employee);
//        }


        employees.add(gson.fromJson(data, Employee.class));


        return employees;
    }


}
