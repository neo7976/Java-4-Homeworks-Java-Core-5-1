package task1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "src/main/resources/data.csv";

        List<Employee> staff = parseCSV(columnMapping, fileName);
        String json = listToJson(staff);

        writeString(json);

    }

    public static List<Employee> parseCSV(String[] columnMapping, String fileName) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(fileName));
        ColumnPositionMappingStrategy<Employee> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Employee.class);
        strategy.setColumnMapping(columnMapping);
        CsvToBean<Employee> csv = new CsvToBeanBuilder<Employee>(reader)
                .withMappingStrategy(strategy)
                .build();
        final List<Employee> parse = csv.parse();
        reader.close();
        return parse;
    }


    public static String listToJson(List<Employee> list) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
//        Type listType = new TypeToken<List<task1.Employee>>() {
//        }.getType();
//        return gson.toJson(list, listType);
        return gson.toJson(list);
    }

    public static void writeString(String json) {
//        try (FileWriter writer = new FileWriter("src/main/resources/new_data_with_type.json")) {
        try (FileWriter writer = new FileWriter("src/main/resources/new_data.json")) {
            writer.write(json);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}