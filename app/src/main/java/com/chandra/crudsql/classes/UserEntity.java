package com.chandra.crudsql.classes;

public class UserEntity  {
    public static String TABLE_NAME = "user";
    public static String COLOUMN_KEY = "id";
    public static String COLOUMN_NAMA = "nama";
    public static String COLOUMN_PASSWORD = "password";
    public static String COLOUMN_IS_LOGIN = "is_login";
    public static String COLOUMN_ROLE= "role";


    private Integer id;
    private String nama;
    private String password;
    private Integer is_login;
    private Integer role;

    public UserEntity(String nama, String password) {
        this.nama = nama;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getPassword() {
        return password;
    }

    public Integer getIs_login() {
        return is_login;
    }

    public Integer getRole() {
        return role;
    }
}
