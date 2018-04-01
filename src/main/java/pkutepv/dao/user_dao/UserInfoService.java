package pkutepv.dao.user_dao;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserInfoService {

    List<UserInfo> getAllUserInfo();
    UserInfo getUserInfoById(int userId);

}
