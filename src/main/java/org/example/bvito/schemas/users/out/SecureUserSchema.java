package org.example.bvito.schemas.users.out;

import org.example.bvito.models.Users;

import java.util.Objects;

/** Secure user schema
 * <p>
 *  Linked with {@link Users User model}
 *  <p>
 *  Has no password field
 *  @author Aleksey
 */
public class SecureUserSchema {

    private Integer uId;
    private String userName;
    private String name;
    private String phoneNumber;

    public SecureUserSchema(Integer uId, String userName, String name, String phoneNumber) {
        this.uId = uId;
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
        return Objects.equals(uId, that.uId) && Objects.equals(userName, that.userName) && Objects.equals(name, that.name) && Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uId, userName, name, phoneNumber);
    }

    @Override
    public String toString() {
        return "SecureUserSchema{" +
                "u_id=" + uId +
                ", user_name='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", phone_number='" + phoneNumber + '\'' +
                '}';
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
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
