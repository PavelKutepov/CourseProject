package pkutepv.dao.user_dao;

import pkutepv.entity.Model;

import javax.persistence.*;
@Entity
@Table(name = "user_info")
public class UserInfo extends Model {
    @Column
    private String lastName;
    @Column
    private String firstName;
    @Column
    private String patronymic;
    @Column
    private String PhoneNumber;

    public UserInfo(String lastName, String firstName, String patronymic, String phoneNumber) {
        super();
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        PhoneNumber = phoneNumber;
    }

    public UserInfo(Long id, String lastName, String firstName, String patronymic, String phoneNumber) {
        super(id);
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        PhoneNumber = phoneNumber;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }
}
