package pkutepv.dao.user_dao;


public class User {
    private final int userId;
    private final String login;

    private final String password;

    private final UserInfo userInfo;

    public User(int userId, String login, String password, UserInfo userInfo) {
        this.userId = userId;
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

    public int getUserId() {
        return userId;
    }
}
