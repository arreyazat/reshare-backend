package application.database;

public class DatabaseQueryException extends Exception{

    public DatabaseQueryException() { super(); }

    public DatabaseQueryException(String msg) { super(msg); }

}