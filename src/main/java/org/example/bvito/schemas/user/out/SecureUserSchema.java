package org.example.bvito.schemas.user.out;

import org.example.bvito.models.User;

import java.util.Objects;

/** Secure user schema
 * <p>
 *  Linked with {@link User User model}
 *  <p>
 *  Has no password field
 *  @author Aleksey
 */
public class SecureUserSchema {

    private Integer userId;
    private String userName;
    private String name;
    private String phoneNumber;

    public SecureUserSchema(Integer userId, String userName, String name, String phoneNumber) {
        this.userId = userId;
        this.userName = userName;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public static SecureUserSchema newInstance() {
        return new SecureUserSchema(1, "Nikola2007", "Nazar'ko Nikolai Vadimovich", "8(928)384-88-23");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SecureUserSchema that)) return false;
        return Objects.equals(userId, that.userId) && Objects.equals(userName, that.userName) && Objects.equals(name, that.name) && Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, name, phoneNumber);
    }

    @Override
    public String toString() {
        return "SecureUserSchema{" +
                "u_id=" + userId +
                ", user_name='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", phone_number='" + phoneNumber + '\'' +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
