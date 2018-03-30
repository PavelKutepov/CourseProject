package pkutepv.dao.user_dao;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import pkutepv.entity.Model;

import javax.persistence.*;

@DatabaseTable(tableName = "user")
public class User extends Model {
    @DatabaseField(id = true, canBeNull = false)
    private final String login;

    @DatabaseField(id = true ,canBeNull = false)
    private final String password;
    @DatabaseField(columnName = "user_info_id",id = true)
    private final UserInfo userInfo;

    public User(String login, String password, UserInfo userInfo) {
        this.login = login;
        this.password = password;
        this.userInfo = userInfo;
    }

    public User(Long id, String login, String password, UserInfo userInfo) {
        super(id);
        this.login = login;
        this.password = password;
        this.userInfo = userInfo;
    }


    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }
}
