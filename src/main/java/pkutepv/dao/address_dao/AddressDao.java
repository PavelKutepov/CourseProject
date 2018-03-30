package pkutepv.dao.address_dao;

import java.util.List;

public interface AddressDao {

    void addAdress(Locality l,String street,String house,String apartament);
    List<Address>getList(Locality l,String street,String house,String apartament);
    void delAdress(Locality l,String street,String house,String apartament);

}
