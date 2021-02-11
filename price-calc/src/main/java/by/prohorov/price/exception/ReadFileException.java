package by.prohorov.price.exception;

/**
 * Created by Artsiom Prokharau 10.02.2021
 */

public class ReadFileException extends RuntimeException {

    public ReadFileException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return getLocalizedMessage();
    }
}
