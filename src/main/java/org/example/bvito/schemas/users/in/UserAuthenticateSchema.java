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
    private String user_name;

    @Schema(description = "password", maxLength = 64, example = "password")
    @NotNull(groups = UsersValidationGroups.OnCreate.class)
    @Size(max = 64)
    private String password;


    public UserAuthenticateSchema(String user_name, String password) {
        this.user_name = user_name;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAuthenticateSchema that)) return false;
        return Objects.equals(getUser_name(), that.getUser_name()) && Objects.equals(getPassword(), that.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser_name(), getPassword());
    }

    @Override
    public String toString() {
        return "UserAuthenticateSchema{" +
                "user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public @NotNull(groups = UsersValidationGroups.OnCreate.class) @Size(max = 64) String getPassword() {
        return password;
    }

    public void setPassword(@NotNull(groups = UsersValidationGroups.OnCreate.class) @Size(max = 64) String password) {
        this.password = password;
    }

    public @NotNull(groups = UsersValidationGroups.OnCreate.class) @Size(max = 64) String getUser_name() {
        return user_name;
    }

    public void setUser_name(@NotNull(groups = UsersValidationGroups.OnCreate.class) @Size(max = 64) String user_name) {
        this.user_name = user_name;
    }

    public static UserAuthenticateSchema newInstance() {
        return new UserAuthenticateSchema("Nikola2007", "password");
    }
}
