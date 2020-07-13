package service;

import model.FruitData;
import java.util.List;

public interface FileService {
    void write(String[] params, String path);
    List<FruitData> read(String path);
}
