package pkutepv.dao.user_dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Transactional(readOnly = true)
public class UserInfoDaoImpl implements UserInfoDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private UserDaoImpl userInfoDao;
    private UserDaoImpl userDao;

    @Override
    public List<UserInfo> getAllUserInfo() { StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM pharmacydatabase.user_info ");
        return  jdbcTemplate.query(sql.toString(),new UserInfoRowMapper());
    }

    @Override
    public UserInfo getUserInfoById(int userId) {
        return null;
    }

    public void setUserInfoDao(UserDaoImpl userInfoDao) {
        this.userInfoDao = userInfoDao;
    }

    public UserDaoImpl getUserInfoDao() {
        return userInfoDao;
    }

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public UserDaoImpl getUserDao() {
        return userDao;
    }

    private class UserInfoRowMapper implements RowMapper<UserInfo> {


        @Override
        public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {

            return new UserInfo(rs.getInt("user_info_id"), rs.getString("lastname"),
                    rs.getString("firstname"), rs.getString("patronymic"), rs.getString("phone_number"));

        }
    }
}
