package pkutepv.dao.address_dao;

import java.util.List;

public interface LocalityDao {

    List<Locality> getAllLocality();

    Locality getLocalityById(int localityId);

    void addLocality(Locality locality);
}
