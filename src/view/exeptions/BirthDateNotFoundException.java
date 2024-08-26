package view.exeptions;

public class BirthDateNotFoundException extends Exception {
    public BirthDateNotFoundException() {
        super("Не удалось получить дату рождения.");
    }
}