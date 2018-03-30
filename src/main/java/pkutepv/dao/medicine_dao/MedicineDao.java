package pkutepv.dao.medicine_dao;

import java.util.List;

public interface MedicineDao {
void addMedicine(String name, String firm, String type, String price, boolean recipe);
void delMebicine(String name,String firm,String type);
List<Medicine> getMedicineList(String name,String type);
}
