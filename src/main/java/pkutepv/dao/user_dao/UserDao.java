package pkutepv.dao.user_dao;

import java.util.List;

public interface UserDao {
    void addUser(String login, String password, UserInfo userInfo);

    void removeUser(String login, String password);

    List<User> getAllUsers();

    User getUserById(int userId);

}
