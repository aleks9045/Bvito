package org.example.bvito.models;

import jakarta.persistence.*;

import java.util.Objects;

/**
 *  Represents user model
 *  @author Aleksey
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "user_name", nullable = false, unique = true, length = 64)
    private String userName;

    @Column(name = "password", nullable = false, length = 60)
    private String password;

    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @Column(name = "phone_number", nullable = false, unique = true, length = 16)
    private String phoneNumber;

    public User(){}

    public User(Integer userId, String userName, String password, String name, String phoneNumber) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    public static User newInstance() {
        return new User(1, "Nikola2007", "password", "Nazar'ko Nikolai Vadimovich", "8(928)384-88-23");
    }

    @Override
    public String toString() {
        return "Users{" +
                "uId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(userId, user.userId) && Objects.equals(userName, user.userName) && Objects.equals(password, user.password) && Objects.equals(name, user.name) && Objects.equals(phoneNumber, user.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, password, name, phoneNumber);
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer uId) {
        this.userId = uId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
