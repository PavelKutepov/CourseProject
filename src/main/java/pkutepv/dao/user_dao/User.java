package pkutepv.dao.user_dao;

import pkutepv.entity.Model;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User extends Model {
    @Column(unique = true)
    private String login;
    @Column

    private String password;
    @OneToOne
    @JoinColumn(name = "userInfo_id")
    private UserInfo userInfo;

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

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserInfo(UserInfo userInfo) {
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
