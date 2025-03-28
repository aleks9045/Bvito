package org.example.bvito.schemas.users.out;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.example.bvito.models.Users;
import org.example.bvito.schemas.ads.out.AdsWithoutUserSchema;
import org.example.bvito.schemas.users.UsersValidationGroups;

import java.util.List;
import java.util.Objects;

public class SecureUserSchema {
    private Integer u_id;

    private String user_name;

    private String name;

    private String phone_number;

    public SecureUserSchema(Integer u_id, String user_name, String name, String phone_number) {
        this.u_id = u_id;
        this.user_name = user_name;
        this.name = name;
        this.phone_number = phone_number;
    }

    public static SecureUserSchema newInstance() {
        return new SecureUserSchema(1, "Nikola2007", "Nazar'ko Nikolai Vadimovich", "8(928)384-88-23");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SecureUserSchema that)) return false;
        return Objects.equals(u_id, that.u_id) && Objects.equals(user_name, that.user_name) && Objects.equals(name, that.name) && Objects.equals(phone_number, that.phone_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(u_id, user_name, name, phone_number);
    }

    @Override
    public String toString() {
        return "SecureUserSchema{" +
                "u_id=" + u_id +
                ", user_name='" + user_name + '\'' +
                ", name='" + name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
