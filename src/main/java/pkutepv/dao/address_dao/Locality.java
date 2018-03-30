package pkutepv.dao.address_dao;

import pkutepv.entity.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


public class Locality extends Model {

    private String city;

    private String district;

    private String local;

    public Locality(Long id, String city, String district, String local) {
        super(id);
        this.city = city;
        this.district = district;
        this.local = local;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getLocal() {
        return local;
    }
}
