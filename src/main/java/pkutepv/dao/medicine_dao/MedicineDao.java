package pkutepv.dao.medicine_dao;

import java.util.List;

public interface MedicineDao {
    void addMedicine(int medicine_id, String name, String firm, String type, int price, boolean recipe, int availability);

    void delMebicine(String name, String firm, String type);

    List<Medicine> getAllMedicine();

    Medicine getMedecineById(int medecineId);
}
