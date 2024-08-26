package view;

import enums.Gender;
import presenter.Presenter;
import view.exeptions.BirthDateNotFoundException;
import view.exeptions.CountDataException;
import view.exeptions.GenderNotFoundException;
import view.exeptions.PhoneNotFoundException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class ConsoleUI implements View {
    private Scanner scanner;
    private boolean work;
    private Presenter Presenter;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        this.work = true;
        Presenter = new Presenter(this);
    }

    @Override
    public void start() {
        while (work) {
            String data_str = getData();
            if (data_str.equals("q")) {
                work = false;
            }
            else {
                if (Presenter.CreateData(data_str)) {
                    Presenter.saveData();
                }
            }
        }
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    public String getData() {
        System.out.print("Введите данные или q для выхода: ");
        return scanner.nextLine();
    }




}
