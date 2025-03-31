package org.example.bvito.schemas.users.in;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.example.bvito.models.Users;
import org.example.bvito.schemas.users.UsersValidationGroups;

import java.util.Objects;

/** Default user schema
 * <p>
 *  Linked with {@link Users User model}
 *  <p>
 *  Has no id field, because database creates it automatically
 *  @author Aleksey
 */
public class UserSchema {

    @Schema(description = "username", maxLength = 64, example = "Nikola2007")
    @NotNull(groups = UsersValidationGroups.OnCreate.class)
    @Size(max = 64)
    private String userName;

    @Schema(description = "password", maxLength = 64, example = "password")
    @NotNull(groups = UsersValidationGroups.OnCreate.class)
    @Size(max = 64)
    private String password;

    @Schema(description = "name", maxLength = 64, example = "Nazar'ko Nikolai Vadimovich")
    @NotNull(groups = UsersValidationGroups.OnCreate.class)
    @Size(max = 64)
    private String name;

    @Schema(description = "phone number", maxLength = 16, example = "8(928)384-88-23")
    @NotNull(groups = UsersValidationGroups.OnCreate.class)
    @Size(max = 16)
    private String phoneNumber;

    public UserSchema(String userName, String password, String name, String phoneNumber) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserSchema that)) return false;
        return Objects.equals(getUserName(), that.getUserName()) && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getName(), that.getName()) && Objects.equals(getPhoneNumber(), that.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName(), getPassword(), getName(), getPhoneNumber());
    }

    @Override
    public String toString() {
        return "UsersSchema{" +
                "user_name='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone_number='" + phoneNumber + '\'' +
                '}';
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public static UserSchema newInstance() {
        return new UserSchema("Nikola2007", "password", "Nazar'ko Nikolai Vadimovich", "8(928)384-88-23");
    }
}
