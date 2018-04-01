package pkutepv.dao.user_dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Transactional(readOnly = true)
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private UserDao userDao;



    @Override
    public List<User> getAllUsers() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM pharmacydatabase.user ");
        return jdbcTemplate.query(sql.toString(), new UserRowMapper());
    }

    @Override
    public User getUserById(int userId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM pharmacydatabase.user WHERE login = ").append(userId);
        return  jdbcTemplate.queryForObject(sql.toString(), new UserRowMapper());
    }

    public void addUser(String login, String password, String lastname, String firstname, String patronymic, String phoneNumber) {

    }

    public void removeUser(String login, String password) {

    }

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    private class UserRowMapper implements RowMapper<User> {
        private UserInfoDao userInfoDao;

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserInfo userInfo = userInfoDao.getUserInfoById(rs.getInt("user_id"));
            return new User(rs.getInt("user_id"), rs.getString("login"), rs.getString("password"), userInfo);
        }
    }
}
