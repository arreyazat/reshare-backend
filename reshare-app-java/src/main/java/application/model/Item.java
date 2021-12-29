package application.model;

//import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonInclude;
//
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Item {

    private final int itemID;

    private boolean cancelled;

    private User user;

    private String name;

    private String description;

    private Item item;


//    private Location location;

    private int quantity;

    private int userID;





//
//    @JsonIgnore
//    private int companyID = -1;
//
//    @JsonIgnore
//    private String userID;
//
//    @JsonIgnore
//    private int itemID = -1;
//
//    @JsonIgnore
//    private int verificationID = -1;
//
//    @JsonIgnore
//    private int rewardID = -1;

    public Item(int itemID, int quantity, String name) {
        this.itemID = itemID;
        this.quantity = quantity;
        this.name = name;
    }

    public Item(int itemID, int quantity, String name, String description) {
        this.itemID = itemID;
        this.quantity = quantity;
        this.name = name;
        this.description = description;
    }

    public Item(int itemID, int userID, int quantity, String name, String description) {
        this.itemID = itemID;
        this.userID = userID;
        this.quantity = quantity;
        this.name = name;
        this.description = description;
    }




    public void setUser(User user) {
        this.user = user;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setName(String name) { this.name = name; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public Item getItem() {
        return item;
    }

    public String getName() { return name; }

    public int getQuantity() {
        return quantity;
    }


//    public String getUserID() {
//        return userID;
//    }

    public int getItemID() {
        return itemID;
    }

    public String getDescription() {
        return description;
    }


    public void cancel() {
        this.cancelled = true;
    }

    public boolean isCancelled() {
        return cancelled;
    }

}
