package nhom7.business;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long customerID;
    private String userName;
    private String password;
    private String lastName;
    private String firstName;
    private String email;
    private String steamFriendCode;
    private boolean isAdmin;

    public Customer() {
        lastName = "";
        firstName = "";
        email = "";
        steamFriendCode = "";
    }

    public Customer(String userName, String password, String lastName, String firstName, String email, String steamFriendCode) {
        this.userName = userName;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.steamFriendCode = steamFriendCode;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSteamFriendCode() {
        return steamFriendCode;
    }

    public void setSteamFriendCode(String steamFriendCode) {
        this.steamFriendCode = steamFriendCode;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", steamFriendCode='" + steamFriendCode + '\'' +
                '}';
    }
}
