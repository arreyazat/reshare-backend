package application.database;


import application.model.*;

import java.util.ArrayList;


public interface DBProvider {

    ArrayList<Item> getAllUserItems(int userID) throws DatabaseQueryException;

    Item getUserItem(int itemID) throws DatabaseQueryException;

    Item addItem(Item item) throws DatabaseInsertException;

//    void updateItem(Item item) throws DatabaseUpdateException;

    User getUser(int userID) throws DatabaseQueryException;

    User addUser(User user) throws DatabaseInsertException;

    //void updateUser(User user) throws DatabaseUpdateException;

    Item getItem(int itemID) throws DatabaseQueryException;

    Item findItem(String itemName) throws DatabaseQueryException;

    boolean deleteItem(int itemID) throws DatabaseDeleteException;

    //void addUserTag(String userID, int itemID) throws DatabaseInsertException;

    //ArrayList<Item> getAllUserTags(String userID) throws DatabaseQueryException;

    // void deleteUserTag(String userID, int itemID) throws DatabaseDeleteException;

    void close() throws DatabaseConnectException;

}