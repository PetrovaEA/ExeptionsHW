package view.exeptions;

public class CountDataException extends Exception {
    public CountDataException(int count) {
        super("Должно быть 6 значений, вы веели " + count);
    }
}
