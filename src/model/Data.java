package model;

import enums.Gender;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Data {
    private String lastName;
    private String name;
    private String patronymic;
    private Date dateOfBirth;
    private Integer phone;
    private Gender gender;

    public Data(String lastName, String name, String patronymic, Date dateOfBirth, Integer phone, Gender gender) {
        this.lastName = lastName;
        this.name = name;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "<" + lastName + ">" +
                "<" + name + ">" +
                "<" + patronymic + ">" +
                "<" + getDateOfBirth() + ">" +
                "<" + phone + ">" +
                "<" + gender + ">" +
                "\n";
    }

    public String getDateOfBirth() {
        return new SimpleDateFormat("dd.MM.yyyy").format(dateOfBirth);
    }

    public String getLastName() {
        return lastName;
    }
}
