package org.example.bvito.schemas;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;


public class UsersSchema {

    @Schema(description = "username", maxLength = 64, example = "Nikola2007")
    @NotNull
    @Size(max = 64)
    private String user_name;

    @Schema(description = "password", maxLength = 64, example = "password")
    @NotNull
    @Size(max = 64)
    private String password;

    @Schema(description = "name", maxLength = 64, example = "Nazar'ko Nikolai Vadimovich")
    @NotNull
    @Size(max = 64)
    private String name;

    @Schema(description = "phone number", maxLength = 16, example = "8(928)384-88-23")
    @NotNull
    @Size(max = 16)
    private String phone_number;

    public UsersSchema(String user_name, String password, String name, String phone_number) {
        this.user_name = user_name;
        this.password = password;
        this.name = name;
        this.phone_number = phone_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsersSchema that)) return false;
        return Objects.equals(getUser_name(), that.getUser_name()) && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getName(), that.getName()) && Objects.equals(getPhone_number(), that.getPhone_number());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser_name(), getPassword(), getName(), getPhone_number());
    }

    @Override
    public String toString() {
        return "UsersSchema{" +
                "user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public static UsersSchema newInstance() {
        return new UsersSchema("Nikola2007", "password", "Nazar'ko Nikolai Vadimovich", "8(928)384-88-23");
    }
}
