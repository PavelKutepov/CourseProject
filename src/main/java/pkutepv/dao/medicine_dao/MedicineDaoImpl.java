package pkutepv.dao.medicine_dao;


import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@Transactional(isolation = Isolation.READ_COMMITTED)
public class MedicineDaoImpl extends NamedParameterJdbcDaoSupport implements MedicineDao {

    @Override
    @Transactional(readOnly = true)
    public void addMedicine(int medicine_id, String name, String firm, String type, int price, boolean recipe, int availability) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO pharmacydatabase.medicine ")
                .append("VALUES( ")
                .append("\"" +medicine_id + "\",")
                .append("\"" + name  + "\",")
                .append("\"" + firm  + "\",")
                .append("\"" + type  + "\",")
                .append( recipe + ",")
                .append( price + ", ")
                .append(availability  + "\" )");
        getJdbcTemplate().execute(sql.toString());
    }

    @Override
    @Transactional(readOnly = true)
    public void delMebicine(String name, String firm, String type) {

    }

    @Override
    @Transactional(readOnly = true)
    public List<Medicine> getAllMedicine() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM pharmacydatabase.medicine ");
        return getNamedParameterJdbcTemplate().query(sql.toString(), new MedicineRowMapper());
    }

    @Override
    @Transactional(readOnly = true)
    public Medicine getMedecineById(int medecineId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM pharmacydatabase.medicine WHERE medicine_id = ").append(medecineId);
        return getJdbcTemplate().queryForObject(sql.toString(), new MedicineRowMapper());
    }

    private class MedicineRowMapper implements RowMapper<Medicine> {

        @Override
        public Medicine mapRow(ResultSet rs, int rowNum) throws SQLException {

            return new Medicine(rs.getInt("medicine_id"), rs.getString("name"),
                    rs.getString("firm"), rs.getString("type"),
                    rs.getInt("price"), rs.getBoolean("recipe"), rs.getInt("availability"));

        }
    }
}
