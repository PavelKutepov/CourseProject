package pkutepv.dao.medicine_dao;

import java.util.List;

public interface MedicineDao {
    void addMedicine(String name, String firm, String type, int price, boolean recipe);

    void delMebicine(String name, String firm, String type);

    List<Medicine> getAllMedicine();

    Medicine getMedecineById(int medecineId);
}
