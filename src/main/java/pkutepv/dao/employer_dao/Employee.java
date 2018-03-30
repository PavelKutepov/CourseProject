package pkutepv.dao.employer_dao;

import pkutepv.entity.Model;
import pkutepv.dao.user_dao.UserInfo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee extends Model {
    @ManyToOne
    @JoinColumn(name = "user_info_id")
    private UserInfo userInfo;
    @ManyToOne
    @JoinColumn(name = "departament_id")
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
