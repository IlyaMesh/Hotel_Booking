package ru.java.HotelBooking.domain;

public class Client {

    private Long client_id;
    private String first_name;
    private String last_name;
    private Long phone;
    private String email;
    private Long credit_card;

    public Client(Long client_id,String first_name,String last_name,Long phone, String email,Long credit_card){
        this.client_id = client_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
        this.email = email;
        this.credit_card = credit_card;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCredit_card() {
        return credit_card;
    }

    public void setCredit_card(Long credit_card) {
        this.credit_card = credit_card;
    }

    @Override
    public String toString() {
        return "Client{" +
                "client_id=" + client_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                '}';
    }

}
