package pkutepv.dao.employer_dao;

import pkutepv.entity.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "departament")
public class Departament extends Model {
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;

    public Departament(Long id, String name, String type) {
        super(id);
        this.name = name;
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
