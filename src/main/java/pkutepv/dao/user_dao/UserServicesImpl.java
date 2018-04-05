package pkutepv.dao.user_dao;


import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional(readOnly = true)
public class UserServicesImpl implements UserServices {


    private UserDao userDao;
    private UserInfoDao userInfoDao;



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

    @Override
    public List<UserInfo> getAllUsersInfo() {
        return userInfoDao.getAllUserInfo();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserInfoDao getUserInfoDao() {
        return userInfoDao;
    }

    public void setUserInfoDao(UserInfoDao userInfoServices) {
        this.userInfoDao = userInfoServices;
    }

    @Override
    public UserInfo getUserInfoById(int userId) {
        return userInfoDao.getUserInfoById(userId);
    }
}
