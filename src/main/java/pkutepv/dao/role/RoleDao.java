package pkutepv.dao.role;

import pkutepv.dao.user_dao.User;

import java.util.List;

public interface RoleDao {
    List<Role> getAllRoles();

    Role getRoleByLogin(String roleLogin);
    void addRole(User user);
}
