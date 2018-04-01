package pkutepv.dao.user_dao;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServices {
   void addUser(String login, String password, String lastname, String firstname, String patronymic, String phoneNumber);

   void removeUser(String login, String password);

   List<User> getAllUsers();

   User getUserById(int userId);

}
