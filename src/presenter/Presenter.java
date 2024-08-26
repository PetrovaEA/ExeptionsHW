package presenter;

import enums.Gender;
import model.Service;
import view.View;
import view.exeptions.BirthDateNotFoundException;
import view.exeptions.CountDataException;
import view.exeptions.GenderNotFoundException;
import view.exeptions.PhoneNotFoundException;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        this.service = new Service();
    }

    public boolean CreateData(String data_str) {
        try {
            LinkedList<String> data = parseData(data_str);
            String lastName = data.pollFirst();
            String name = data.pollFirst();
            String patronymic = data.pollFirst();
            Date dateOfBirth = getBirthDate(data);
            Integer phone = getPhone(data);
            Gender gender = getGender(data);
            service.setData(lastName, name, patronymic, dateOfBirth, phone, gender);
            view.printAnswer("Данные загружены");
            return true;
        } catch (Exception e) {
            view.printAnswer(e.getMessage());
            return false;
        }
    }

    public void saveData() {
        try {
            String path = service.saveData();
            view.printAnswer("Данные сохранены в файл: " + path);
        } catch (IOException e) {
            e.printStackTrace();
            view.printAnswer("Не удалось сохранить данные;");
        }
    }

    private LinkedList<String> parseData(String str) throws CountDataException {
        List<String> args = Arrays.asList(str.split(" "));
        if (args.size() != 6) {
            throw new CountDataException(args.size());
        }
        return new LinkedList<>(args);
    }

    private Date getBirthDate(LinkedList<String> args) throws BirthDateNotFoundException {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        Date birthDate = null;
        for (String arg : args) {
            try {
                birthDate = df.parse(arg);
                break;
            } catch (ParseException e) {
                continue;
            }
        }
        if (birthDate == null) {
            throw new BirthDateNotFoundException();
        }
        return birthDate;
    }

    private Integer getPhone(LinkedList<String> args) throws PhoneNotFoundException {
        Integer Phone = null;
        for (String arg : args) {
            try {
                Phone = Integer.parseInt(arg);
                break;
            } catch (NumberFormatException e) {
                continue;
            }
        }
        if (Phone == null) {
            throw new PhoneNotFoundException();
        }
        return Phone;
    }

    private Gender getGender(LinkedList<String> args) throws GenderNotFoundException {
        Gender gender = null;
        for (String arg : args) {
            try {
                gender = Gender.valueOf(arg);
                break;
            } catch (IllegalArgumentException e) {
                continue;
            }
        }
        if (gender == null) {
            throw new GenderNotFoundException();
        }
        return gender;
    }
}
