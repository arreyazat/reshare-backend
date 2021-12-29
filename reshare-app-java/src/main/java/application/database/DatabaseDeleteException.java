package application.database;

public class DatabaseDeleteException extends Exception {

    public DatabaseDeleteException() {
        super();
    }

    public DatabaseDeleteException(String msg) {
        super(msg);
    }
}