package pkutepv.dao.role;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import pkutepv.dao.user_dao.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@Transactional(isolation = Isolation.READ_COMMITTED)
public class RoleDaoImpl extends NamedParameterJdbcDaoSupport implements RoleDao {

    @Override
    public List<Role> getAllRoles() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM pharmacydatabase.role ");
        return getNamedParameterJdbcTemplate().query(sql.toString(), new RoleRowMapper());
    }

    @Override
    public Role getRoleByLogin(String roleLogin) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM pharmacydatabase.role WHERE login = ").append(roleLogin);
        return getNamedParameterJdbcTemplate().queryForObject(sql.toString(), new HashMap<>(), new RoleRowMapper());
    }

    @Override
    public void addRole(User user) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO pharmacydatabase.role VALUES( ")
                .append(user.getLogin());
        getJdbcTemplate().execute(sql.toString());
    }


    private class RoleRowMapper implements RowMapper<Role> {


        @Override
        public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Role(rs.getString("login"), rs.getString("role"));

        }
    }
}
