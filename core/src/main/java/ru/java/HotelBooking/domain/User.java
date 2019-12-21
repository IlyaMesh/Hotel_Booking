package ru.java.HotelBooking.domain;

import java.util.Objects;

public class User {

    private Long user_id;
    private String login;
    private String password;
    private String email;

    public User(Long id, String login, String password, String email) {
        this.user_id = id;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public User(){}

    public User(String userLogin, String userPassword) {
        this.login = userLogin;
        this.password = userPassword;
    }

    public Long getUser_id() {
        return user_id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
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
                "id=" + user_id +
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
        return Objects.hash(user_id, login, password, email);
    }
}
