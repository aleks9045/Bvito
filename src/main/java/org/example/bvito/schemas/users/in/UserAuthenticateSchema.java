package org.example.bvito.schemas.users.in;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.example.bvito.models.Users;
import org.example.bvito.schemas.users.UsersValidationGroups;

import java.util.Objects;

/** Authentication user schema
 * <p>
 *  Linked with {@link Users User model}
 *  <p>
 *  Has only username and password fields
 *  @author Aleksey
 */
public class UserAuthenticateSchema {

    @Schema(description = "username", maxLength = 64, example = "Nikola2007")
    @NotNull(groups = UsersValidationGroups.OnCreate.class)
    @Size(max = 64)
    private String userName;

    @Schema(description = "password", maxLength = 64, example = "password")
    @NotNull(groups = UsersValidationGroups.OnCreate.class)
    @Size(max = 64)
    private String password;


    public UserAuthenticateSchema(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAuthenticateSchema that)) return false;
        return Objects.equals(getUserName(), that.getUserName()) && Objects.equals(getPassword(), that.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName(), getPassword());
    }

    @Override
    public String toString() {
        return "UserAuthenticateSchema{" +
                "user_name='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public @NotNull(groups = UsersValidationGroups.OnCreate.class) @Size(max = 64) String getPassword() {
        return password;
    }

    public void setPassword(@NotNull(groups = UsersValidationGroups.OnCreate.class) @Size(max = 64) String password) {
        this.password = password;
    }

    public @NotNull(groups = UsersValidationGroups.OnCreate.class) @Size(max = 64) String getUserName() {
        return userName;
    }

    public void setUserName(@NotNull(groups = UsersValidationGroups.OnCreate.class) @Size(max = 64) String userName) {
        this.userName = userName;
    }

    public static UserAuthenticateSchema newInstance() {
        return new UserAuthenticateSchema("Nikola2007", "password");
    }
}
