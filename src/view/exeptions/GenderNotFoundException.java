package view.exeptions;

public class GenderNotFoundException extends Exception {
    public GenderNotFoundException() {
        super("Не удалось получить информацию о поле.");
    }
}