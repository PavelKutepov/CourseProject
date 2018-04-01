package pkutepv.dao.user_dao;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional(readOnly = true)
public class UserServicesImpl implements  UserServices{


    private UserDao userDao;
    private UserInfoService userInfoServices;
    private UserServices userServices;


    @Override
    public void addUser(String login, String password, String lastname, String firstname, String patronymic, String phoneNumber) {

    }

    @Override
    public void removeUser(String login, String password) {

    }

    @Override
    public List<User> getAllUsers() {
      return userDao.getAllUsers();
    }

    @Override
    public User getUserById(int userId) {
       return userDao.getUserById(userId);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }



    public UserInfoService getUserInfoServices() {
        return userInfoServices;
    }

    public void setUserInfoServices(UserInfoService userInfoServices) {
        this.userInfoServices = userInfoServices;
    }

    public void setUserServices(UserServicesImpl userServices) {
        this.userServices = userServices;
    }

    public UserServices getUserServices() {
        return userServices;
    }
}
