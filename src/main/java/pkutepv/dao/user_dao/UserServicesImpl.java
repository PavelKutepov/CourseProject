package pkutepv.dao.user_dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pkutepv.dao.user_dao.UserDao;

import javax.transaction.Transactional;

@Service
public class UserServicesImpl {
    @Autowired
    private UserDao userDao;

    @Transactional
    void addUser(String login, String password, String lastname,String firstname, String patronymic, String phoneNumber){
        userDao.addUser(login, password, lastname,firstname, patronymic,phoneNumber);
    }
    @Transactional
    void removeUser(String login, String password){
        userDao.removeUser(login,password);
    }
}
