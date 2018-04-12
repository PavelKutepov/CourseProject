package pkutepv.dao.medicine_dao;

import java.util.List;

public class MedicineServiceImpl implements MedicineService {

    private MedicineDao medicineDao;

    @Override

    public void addMedicine(String name, String firm, String type, int price, boolean recipe) {
        medicineDao.addMedicine(name, firm, type, price, recipe);
    }

    @Override
    public void delMebicine(String name, String firm, String type) {

    }

    @Override
    public List<Medicine> getAllMedicine() {
        return medicineDao.getAllMedicine();
    }

    @Override
    public Medicine getMedecineById(int medecineId) {
        return medicineDao.getMedecineById(medecineId);
    }

    public void setMedicineDao(MedicineDao medicineDao) {
        this.medicineDao = medicineDao;
    }
}
