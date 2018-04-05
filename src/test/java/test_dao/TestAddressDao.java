package test_dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pkutepv.dao.address_dao.AddressDao;
import pkutepv.dao.address_dao.AddressService;
import pkutepv.dao.address_dao.Locality;
import pkutepv.dao.address_dao.LocalityDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:WEB-INF/applicationContext.xml")
public class TestAddressDao {

    @Autowired
    AddressService addressService;
    @Autowired
    LocalityDao localityDao;

    @Test
    public void addAddressTest(){
        System.out.println("addAddressTest");
        Locality locality = new Locality("Moсква","Московская Область","Москва");
        localityDao.addLocality(locality);

    addressService.addAdress("Снежная",24,3,locality);
    }

}
