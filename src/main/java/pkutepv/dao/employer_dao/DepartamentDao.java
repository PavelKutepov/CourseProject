package pkutepv.dao.employer_dao;

import java.util.List;

public interface DepartamentDao {
    List<Departament> getAllDepartament();

    Departament getDepartamentById(int departamentId);

    void AddDepartament(String name, String position);
}
