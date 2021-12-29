package application.database;

public class DatabaseUpdateException extends Exception {

    public DatabaseUpdateException() {
        super();
    }

    public DatabaseUpdateException(String msg) {
        super(msg);
    }
}