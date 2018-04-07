package pkutepv.dao.user_dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User addUser(String login, String password, UserInfo userInfo);

    void removeUser(String login, String password);

    List<User> getAllUsers();

    User getUserById(int userId);

    List<UserInfo> getAllUsersInfo();

    UserInfo getUserInfoById(int userId);

    UserInfo addUserInfo(String lastName, String firstName, String patronymic, String phoneNumber);
}
