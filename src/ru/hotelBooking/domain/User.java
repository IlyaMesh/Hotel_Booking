package ru.hotelBooking.domain;

import java.util.Objects;

public class User {

    private Long id;
    private String login;
    private String password;
    private String email;

    public User(Long id, String login, String password, String email) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public User(){}

    public User(String userLogin, String userPassword) {
        this.login = userLogin;
        this.password = userPassword;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return  Objects.equals(login, user.login) &&
                Objects.equals(password, user.password);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, email);
    }
}
