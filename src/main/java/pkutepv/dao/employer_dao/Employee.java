package pkutepv.dao.employer_dao;

import pkutepv.entity.Model;
import pkutepv.dao.user_dao.UserInfo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


public class Employee extends Model {

    private UserInfo userInfo;

    private Departament departament;

    public Employee(Long id, UserInfo userInfo, Departament departament) {
        super(id);
        this.userInfo = userInfo;
        this.departament = departament;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public Departament getDepartament() {
        return departament;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }
}
