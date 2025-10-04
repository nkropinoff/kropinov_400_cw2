package ru.itis.kpfu.kropinov.entity;


public class User {
    private Integer id;
    private String name;
    private String lastname;
    private String login;
    private String password;

    public User() {}

    public User(Integer id, String name, String lastname, String login, String password) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.password = password;
        this.login = login;
    }

    public User(String name, String lastname, String login,  String password) {
        this.name = name;
        this.lastname = lastname;
        this.login = login;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
