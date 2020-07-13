package service.impl;

import model.FruitData;
import model.Type;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import service.FileService;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class FileServiceImpl implements FileService {

    static final String[] HEADERS = {"type", "fruit", "quantity", "date"};

    @Override
    public void write(String[] params, String path) {
        try (FileWriter writer = new FileWriter(path, true);
             BufferedWriter reader = new BufferedWriter(writer)) {
            for (int i = 0; i < params.length - 1; i++) {
                reader.append(params[i]).append(",");
            }
            reader.append(params[params.length - 1]).append("\n");
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    @Override
    public List<FruitData> read(String path) {
        List<FruitData> fruits = new ArrayList<>();
        try {
            Reader file = new FileReader(path);
            Iterable<CSVRecord> records = CSVFormat.DEFAULT
                    .withHeader(HEADERS)
                    .withFirstRecordAsHeader()
                    .parse(file);
            for (CSVRecord record : records) {
                String type = record.get(0);
                String name = record.get(1);
                int quantity = Integer.parseInt(record.get(2));
                String date = record.get(3);
                fruits.add(new FruitData(Type.valueOf(type), name, quantity, date));
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        return fruits;
    }
}
