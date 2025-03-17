package ro.ase.cts.classes;

public class User {
    private int userID;
    private static int numberOfUsers;
    private String userName;

    public User() {
        numberOfUsers++;
        this.userID = numberOfUsers;
        userName = "";
    }

    public User(String userName) {
        numberOfUsers++;
        this.userID = numberOfUsers;
        this.userName = userName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", UserName='" + userName + '\'' +
                '}';
    }
}
