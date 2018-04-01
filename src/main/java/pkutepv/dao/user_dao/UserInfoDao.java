package pkutepv.dao.user_dao;

import java.util.List;

public interface UserInfoDao {
     List<UserInfo> getAllUserInfo();
    UserInfo getUserInfoById(int userId);

}

