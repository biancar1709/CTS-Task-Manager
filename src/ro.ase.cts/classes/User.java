package ro.ase.cts.classes;

public class User {
    private int userID;
    private String UserName;

    public User() {
        this.userID = 0;
        UserName = "";
    }

    public User(int userID, String userName) {
        this.userID = userID;
        UserName = userName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", UserName='" + UserName + '\'' +
                '}';
    }
}
