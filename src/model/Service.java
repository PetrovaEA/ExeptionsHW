package model;

import enums.Gender;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

public class Service {
    private Data data;
    String path;

    public void setData(String lastName, String name, String patronymic, Date dateOfBirth, Integer phone, Gender gender) {
        this.data = new Data(lastName, name, patronymic, dateOfBirth, phone, gender);
        this.path = System.getProperty("user.dir") + "/src/base/";
    }

    public String saveData() throws IOException {
        String file_path = path + data.getLastName() +".txt";
        File file = new File(file_path);
        file.createNewFile();
        try (FileWriter writer = new FileWriter(file, true)) {
            String forWrite = data.toString();
            writer.write(forWrite);
            return file.getAbsolutePath();
        }
    }




}
