package pkutepv.dao.user_dao;

import org.springframework.stereotype.Service;

@Service
public interface UserServices {
   void addUser(String login, String password, UserInfo userInfo);
   void removeUser(String login, String password);

}
