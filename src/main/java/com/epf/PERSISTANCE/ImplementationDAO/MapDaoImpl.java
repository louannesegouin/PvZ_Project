package com.epf.PERSISTANCE.ImplementationDAO;

import com.epf.CORE.models.Map;
import com.epf.PERSISTANCE.InterfaceDAO.MapDao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class MapDaoImpl implements MapDao {

    private final JdbcTemplate jdbcTemplate;

    public MapDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper pour transformer une ligne en objet Map
    private static final class MapRowMapper implements RowMapper<Map> {
        @Override
        public Map mapRow(ResultSet rs, int rowNum) throws SQLException {
            Map gameMap = new Map();
            gameMap.setId(rs.getLong("id"));
            gameMap.setRows(rs.getInt("rows"));
            gameMap.setColumns(rs.getInt("columns"));
            gameMap.setPathimage(rs.getString("pathimage"));
            return gameMap;
        }
    }

    @Override
    public Map create(Map gameMap) {
        String sql = "INSERT INTO maps (rows, columns, pathimage) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, gameMap.getRows(), gameMap.getColumns(), gameMap.getPathimage());
        return gameMap;
    }

    @Override
    public Optional<Map> findById(Long id) {
        String sql = "SELECT id, rows, columns, pathimage FROM maps WHERE id = ?";
        try {
            Map gameMap = jdbcTemplate.queryForObject(sql, new MapRowMapper(), id);
            return Optional.ofNullable(gameMap);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Map> findAll() {
        String sql = "SELECT id, rows, columns, pathimage FROM maps";
        return jdbcTemplate.query(sql, new MapRowMapper());
    }

    @Override
    public Map update(Map gameMap) {
        String sql = "UPDATE maps SET rows = ?, columns = ?, pathimage = ? WHERE id = ?";
        jdbcTemplate.update(sql, gameMap.getRows(), gameMap.getColumns(), gameMap.getPathimage(), gameMap.getId());
        return gameMap;
    }

    @Override
    public boolean deleteById(Long id) {
        String sql = "DELETE FROM maps WHERE id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }
}
