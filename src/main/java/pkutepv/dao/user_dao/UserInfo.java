package pkutepv.dao.user_dao;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import pkutepv.entity.Model;

import javax.persistence.*;
public class UserInfo {
    private final int userInfoId;

    private final String lastName;


    private final String firstName;


    private final String patronymic;


    private final String PhoneNumber;

    public UserInfo(int userInfoId, String lastName, String firstName, String patronymic, String phoneNumber) {
        this.userInfoId = userInfoId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
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
