package ro.ase.cts.classes;

public class User {
    private int userID;
    private static int numberOfUsers;
    private String userName;
    private String userType;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }


    public User() {
        numberOfUsers++;
        this.userID = numberOfUsers;
        userName = "";
    }

    public User(String userName) {
        numberOfUsers++;
        this.userID = numberOfUsers;
        this.userName = userName;
        if(userName.equals("admin")){
            this.userType = "admin";
        }else{
            this.userType = "regular";
        }
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
