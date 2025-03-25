package org.example.bvito.schemas;

import io.swagger.v3.oas.annotations.media.Schema;


public class UsersSchema {

    @Schema(description = "username", maxLength = 64, example = "Nikola2007")
    private String user_name;

    @Schema(description = "password", maxLength = 64, example = "password")
    private String password;

    @Schema(description = "name", maxLength = 64, example = "Nazar'ko Nikolai Vadimovich")
    private String name;

    @Schema(description = "phone number", maxLength = 16, example = "8(928)384-88-23")
    private String phone_number;

    public UsersSchema(String user_name, String password, String name, String phone_number) {
        this.user_name = user_name;
        this.password = password;
        this.name = name;
        this.phone_number = phone_number;
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
