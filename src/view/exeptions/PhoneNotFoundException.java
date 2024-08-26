package view.exeptions;

public class PhoneNotFoundException extends Exception {
    public PhoneNotFoundException() {
        super("Не удалось получить номер телефона.");
    }
}