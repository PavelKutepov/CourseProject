package pkutepv.dao.user_dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import pkutepv.dao.role.RoleDao;

import javax.jws.soap.SOAPBinding;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;


@Transactional(isolation = Isolation.READ_COMMITTED)
public class UserDaoImpl extends NamedParameterJdbcDaoSupport implements UserDao {

    private UserDao userDao;
    private UserInfoDao userInfoDao;
    private RoleDao roleDao;

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM pharmacydatabase.user ");
        return getNamedParameterJdbcTemplate().query(sql.toString(), new UserRowMapper());
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(int userId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM pharmacydatabase.user WHERE user_id = ").append(userId);
        return getJdbcTemplate().queryForObject(sql.toString(), new UserRowMapper());
    }
    @Transactional(readOnly = true)
    public User addUser(String login, String password, UserInfo userInfo) {
        userInfo= userInfoDao.addUserInfo(userInfo.getLastName(),userInfo.getFirstName(),userInfo.getPatronymic(),userInfo.getPhoneNumber());
        StringBuilder sql = new StringBuilder();

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("user_id", userInfo.getUserInfoId());
        mapSqlParameterSource.addValue("login", login);
        mapSqlParameterSource.addValue("password", password);

        sql.append("INSERT INTO pharmacydatabase.user  (user_id,login,password)")
                .append("VALUES( ")
                .append(" :user_id , ")
                .append(" :login, ")
                .append(" :password )");
        getNamedParameterJdbcTemplate().update(sql.toString(), mapSqlParameterSource);
        User newUser = new User(userInfo.getUserInfoId(), login, password, userInfo);
        roleDao.addRole(newUser);
        return newUser;
    }
    @Transactional(readOnly = true)
    public void removeUser(String login, String password) {

    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserInfoDao(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    private class UserRowMapper implements RowMapper<User> {


        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserInfo userInfo = userInfoDao.getUserInfoById(rs.getInt("user_id"));
            return new User(rs.getInt("user_id"), rs.getString("login"), rs.getString("password"), userInfo);
        }
    }
}
