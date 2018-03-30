package pkutepv.dao.user_dao;


import org.springframework.stereotype.Service;



@Service
public class UserServicesImpl implements  UserServices{


    private UserServicesImpl userDao;

    public void setUserDao(UserServicesImpl userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(String login, String password, UserInfo userInfo) {

    }

    @Override
    public void removeUser(String login, String password) {

    }

    public UserServicesImpl getUserDao() {
        return userDao;
    }
}
