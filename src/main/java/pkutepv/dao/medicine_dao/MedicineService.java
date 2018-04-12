package pkutepv.dao.medicine_dao;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface MedicineService {
    void addMedicine(String name, String firm, String type, int price, boolean recipe);

    void delMebicine(String name, String firm, String type);

    List<Medicine> getAllMedicine();

    Medicine getMedecineById(int medecineId);
}
