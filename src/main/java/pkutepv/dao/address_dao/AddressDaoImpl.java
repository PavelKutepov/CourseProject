package pkutepv.dao.address_dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.util.HashMap;
import java.util.List;

@Transactional(isolation = Isolation.READ_COMMITTED)
public class AddressDaoImpl extends NamedParameterJdbcDaoSupport implements AddressDao {

    private AddressDao addressDao;
    private LocalityDao localityDao;

    @Override
    @Transactional(readOnly = true)
    public void addAddress(String street, int house, int apartment, Locality locality) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("street", street);
        mapSqlParameterSource.addValue("house", house);
        mapSqlParameterSource.addValue("apartment", apartment);
        mapSqlParameterSource.addValue("locality_id", locality.getLocality_id());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO pharmacydatabase.address (street,house,apartment,locality_id)  ")
                .append("VALUES( ")
                .append(" :street, ")
                .append(" :house, ")
                .append(" :apartment, ")
                .append("  :locality_id )");

        getNamedParameterJdbcTemplate().update(sql.toString(), mapSqlParameterSource, keyHolder);
    }

    @Override
    @Transactional(readOnly = true)
    public Address getAddressForId(int addressId) {
        StringBuilder sql = new StringBuilder();
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("address_id", addressId);
        sql.append("SELECT * FROM pharmacydatabase.address WHERE address_id = :address_id");
        return getNamedParameterJdbcTemplate().queryForObject(sql.toString(), mapSqlParameterSource, new AddressRowMapper());
    }

    @Override
    @Transactional(readOnly = true)
    public List<Address> getAllAddressList() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM pharmacydatabase.address");
        return getNamedParameterJdbcTemplate().query(sql.toString(), new AddressRowMapper());
    }

    @Override
    public void delAddress(Locality l, String street, String house, String apartament) {

    }

    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    public void setLocalityDao(LocalityDao localityDao) {
        this.localityDao = localityDao;
    }

    public AddressDao getAddressDao() {
        return addressDao;
    }

    private class AddressRowMapper implements RowMapper<Address> {


        @Override
        public Address mapRow(ResultSet rs, int rowNum) throws SQLException {

            Locality locality = localityDao.getLocalityById(rs.getInt("locality_id"));
            return new Address(rs.getInt("address_id"), rs.getString("street"),
                    rs.getInt("house"), rs.getInt("apartment"), locality);
        }
    }
}
