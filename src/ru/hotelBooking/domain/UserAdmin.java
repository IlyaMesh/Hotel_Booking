package ru.hotelBooking.domain;

public class UserAdmin extends AbstractUser {

    //Пусть правами администратора могут обладать разные сотрудники компании
    private String job;

    public UserAdmin(Long id, String login, String email, String pass, String job) {
        super(id,login,email,pass);
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "UserAdmin{" +
                super.toString()+
                "job='" + job + '\'' +
                '}';
    }
}
