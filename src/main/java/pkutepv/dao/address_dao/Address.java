package pkutepv.dao.address_dao;

import pkutepv.entity.Model;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address extends Model {
    @OneToMany
    @JoinColumn(name = "locality_id")
    private Locality locality;
    @Column(name = "street")
    private String street;
    @Column(name = "house")
    private int  house;
    @Column(name = "apartment")
    private int apartment;
    public Address() {
    }
    public Address(Long id) {
        super(id);
    }

    public Address(Long id, Locality locality, String street, int house, int apartment) {
        super(id);
        this.locality = locality;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
    }

    public void setLocality(Locality locality) {
        this.locality = locality;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    public Locality getLocality() {
        return locality;
    }

    public String getStreet() {
        return street;
    }

    public int getHouse() {
        return house;
    }

    public int getApartment() {
        return apartment;
    }


}
