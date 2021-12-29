package application.model;

import java.util.ArrayList;

public class User {
    private final int userID;

    private final String firstName;

    private final String lastName;

    private final String email;

    private ArrayList<Item> items;

    public User(int userID, String firstName, String lastName, String email) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.items = new ArrayList<>();
    }






    public int getUserID() {
        return userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }


    public ArrayList<Item> getItems() {
        return items;
    }

    public User basicInfo() {
        return new User(userID, firstName, lastName, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", items=" + items +
                '}';
    }
}
