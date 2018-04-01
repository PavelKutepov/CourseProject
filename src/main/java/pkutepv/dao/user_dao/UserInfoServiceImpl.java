package pkutepv.dao.user_dao;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional(readOnly = true)
public class UserInfoServiceImpl implements UserInfoService {

   private UserInfoDao userInfoDao;
    private UserInfoService userInfoServices;


    @Override
    public List<UserInfo> getAllUserInfo() {
        return userInfoDao.getAllUserInfo();
    }

    @Override
    public UserInfo getUserInfoById(int userId) {
        return userInfoDao.getUserInfoById(userId);
    }

    public UserInfoDao getUserInfoDao() {
        return userInfoDao;
    }

    public void setUserInfoDao(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }


    public void setUserInfoServices(UserInfoServiceImpl userInfoServices) {
        this.userInfoServices = userInfoServices;
    }

    public UserInfoService getUserInfoServices() {
        return userInfoServices;
    }
}
