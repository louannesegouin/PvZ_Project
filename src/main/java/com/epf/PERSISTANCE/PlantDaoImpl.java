package com.epf.PERSISTANCE;

import com.epf.CORE.Plant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class PlantDaoImpl implements PlantDao {

    private final JdbcTemplate jdbcTemplate;

    public PlantDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper pour transformer une ligne en objet Plant
    private static final class PlantRowMapper implements RowMapper<Plant> {
        @Override
        public Plant mapRow(ResultSet rs, int rowNum) throws SQLException {
            Plant plant = new Plant();
            plant.setId(rs.getLong("id"));
            plant.setName(rs.getString("name"));
            plant.setHealth(rs.getInt("health"));
            plant.setDamagerpersec(rs.getInt("damagepersec"));
            plant.setDamage(rs.getInt("damage"));
            plant.setCost(rs.getInt("cost"));
            plant.setSunpersec(rs.getInt("sunpersec"));
            plant.setEffect(rs.getString("effect"));
            plant.setPathimage(rs.getString("pathimage"));
            return plant;
        }
    }

    @Override
    public Plant create(Plant plant) {
        String sql = "INSERT INTO plants (name, health, damagepersec, damage, cost, sunpersec, effect, pathimage) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    jdbcTemplate.update(sql, plant.getName(), plant.getHealth(), plant.getDamagerpersec(), plant.getDamage(), plant.getCost(), plant.getSunpersec(), plant.getEffect(), plant.getPathimage(), plant.getPathimage());
        return plant;
    }

    @Override
    public Optional<Plant> findById(Long id) {
        String sql = "SELECT id, name, health, damagerpersec, cost, sunpersec, effect, pathimage FROM plants WHERE id = ?";
        try {
            Plant plant = jdbcTemplate.queryForObject(sql, new PlantRowMapper(), id);
            return Optional.ofNullable(plant);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Plant> findAll() {
        String sql = "SELECT id, name, health, damagerpersec, damage, cost, sunpersec, effect, pathimage FROM plants";
        return jdbcTemplate.query(sql, new PlantRowMapper());
    }

    @Override
    public Plant update(Plant plant) {
        String sql = "UPDATE plants SET name = ?, health = ?, damagerpersec = ?, damage = ?, cost = ?, sunpersec = ?, effect = ?, pathimage = ? WHERE id = ?";
        jdbcTemplate.update(sql, plant.getName(), plant.getHealth(), plant.getDamagerpersec(), plant.getDamage(), plant.getCost(), plant.getSunpersec(), plant.getEffect(), plant.getPathimage(), plant.getId());
        return plant;
    }

    @Override
    public boolean deleteById(Long id) {
        String sql = "DELETE FROM plants WHERE id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }
}
