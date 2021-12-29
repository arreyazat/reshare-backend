package application.database;

import application.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Properties;
import java.util.Scanner;

public class Db2 implements DBProvider{

    private final Connection connection;

    public Db2() throws DatabaseConnectException {
        try {
            System.out.println("Trying to connect to database...");
            Properties properties = new Properties();
            properties.load(Db2.class.getClassLoader().getResourceAsStream("application.properties"));

            System.out.println("Application properties loaded");
            //Works until here

            connection = DriverManager.getConnection("jdbc:db2://3883e7e4-18f5-4afe-be8c-fa31c41761d2.bs2io90l08kqb1od8lcg.databases.appdomain.cloud:31498/bludb:user=dwz96999;password=9H6igjbTO6ENSitP;sslConnection=true;");
            System.out.println("Connection Established");

            Scanner scanner = new Scanner(Objects.requireNonNull(Db2.class.getClassLoader().getResourceAsStream("schema.sql")));
            Statement statement = connection.createStatement();
            StringBuilder instructions = new StringBuilder();
            while (scanner.hasNextLine()) {
                System.out.println("Inside While");
                instructions.append(scanner.nextLine());
            }
            //statement.execute(instructions.toString());
        } catch ( Exception e ) {
            System.out.println(e);
            throw new DatabaseConnectException();
        }
    }


    @Override
    public ArrayList<Item> getAllUserItems(int userID) throws DatabaseQueryException {
        try {
            PreparedStatement readStatement = connection.prepareStatement(
                    "SELECT * FROM UserItems WHERE user_id='" + userID + "';"
            );
            ResultSet resultSet = readStatement.executeQuery();
            System.out.println("Inside the getAllUserItems() function");
            System.out.println(resultSet);
            return translateUserItem(resultSet);
        } catch (SQLException e) {
            throw new DatabaseQueryException("Cannot connect to database");
        }
    }

    @Override
    public Item getUserItem(int itemID) throws DatabaseQueryException {
        return null;
    }

    @Override
    public Item addItem(Item item) throws DatabaseInsertException {
        return null;
    }

    @Override
    public User getUser(int userID) throws DatabaseQueryException {
        try {
            System.out.println("Inside the Db2 GetUser()");
            PreparedStatement readStatement = connection.prepareStatement("SELECT * FROM Users where user_id='" + userID + "';");
            ResultSet resultSet = readStatement.executeQuery();
            System.out.println("Resultset: " + resultSet);

            return translateUser(resultSet);
        } catch (SQLException e) {
            System.out.println(e);
            throw new DatabaseQueryException();
        }
    }

    @Override
    public User addUser(User user) throws DatabaseInsertException {
        return null;
    }

    @Override
    public Item getItem(int itemID) throws DatabaseQueryException {
        return null;
    }

    @Override
    public Item findItem(String itemName) throws DatabaseQueryException {
        return null;
    }

    @Override
    public boolean deleteItem(int itemID) throws DatabaseDeleteException {
        return false;
    }

    @Override
    public void close() throws DatabaseConnectException {
        System.out.println("Inside Close Database");
        try {
            connection.close();
        } catch (SQLException e) {
            throw new DatabaseConnectException("Cannot close the connection");
        }
    }

    private ArrayList<Item> translateUserItem(ResultSet resultSet) throws SQLException {
        ArrayList<Item> result = new ArrayList<>();

        while (resultSet.next()) {
            result.add( new Item(
                    resultSet.getInt("itemID"),
                    resultSet.getInt("userID"),
                    resultSet.getInt("quantity"),
                    resultSet.getString("name"),
                    resultSet.getString("description")
            ));
        }

        System.out.println("Inside the translateUserItem() function");
        System.out.println(result);

        return result;
    }

    private User translateUser(ResultSet resultSet) throws SQLException {
        if (!resultSet.next()) {
            throw new SQLException();
        }

        User user = new User(
                resultSet.getInt("user_id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("email")
        );


        return user;
    }


}

