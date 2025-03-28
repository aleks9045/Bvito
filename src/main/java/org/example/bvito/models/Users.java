package org.example.bvito.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer u_id;

    @Column(name = "user_name", nullable = false, unique = true, length = 64)
    private String userName;

    @Column(name = "password", nullable = false, length = 60)
    private String password;

    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @Column(name = "phone_number", nullable = false, unique = true, length = 16)
    private String phoneNumber;

    public Users(){}

    public Users(Integer u_id, String userName, String password, String name, String phoneNumber) {
        this.u_id = u_id;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users users)) return false;
        return Objects.equals(getU_id(), users.getU_id())
                && Objects.equals(getUserName(), users.getUserName())
                && Objects.equals(getPassword(), users.getPassword())
                && Objects.equals(getName(), users.getName())
                && Objects.equals(getPhoneNumber(), users.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getU_id(), getUserName(), getPassword(), getName(), getPhoneNumber());
    }

    @Override
    public String toString() {
        return "Users{" +
                "u_id=" + u_id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public static Users newInstance() {
        return new Users(1, "Nikola2007", "password", "Nazar'ko Nikolai Vadimovich", "8(928)384-88-23");
    }

    public void setU_id(Integer id) {
        this.u_id = id;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getU_id() {
        return u_id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


}
