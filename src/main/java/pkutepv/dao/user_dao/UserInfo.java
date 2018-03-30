package pkutepv.dao.user_dao;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import pkutepv.entity.Model;

import javax.persistence.*;
@DatabaseTable(tableName = "user_info")
public class UserInfo {
    @DatabaseField(columnName = "user_info_id",foreign = true, canBeNull = false, foreignAutoRefresh = true)
    private final int userInfoId;
    @DatabaseField( canBeNull = false)
    private final String lastName;

    @DatabaseField( canBeNull = false)
    private final String firstName;

    @DatabaseField(canBeNull = false)
    private final String patronymic;

    @DatabaseField(unique = true, canBeNull = false)
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
