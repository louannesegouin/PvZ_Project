package com.epf.PERSISTANCE.ImplementationDAO;

import com.epf.CORE.models.Map;
import com.epf.PERSISTANCE.InterfaceDAO.MapDao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
            gameMap.setId(rs.getLong("id_map"));
            gameMap.setRows(rs.getInt("ligne"));
            gameMap.setColumns(rs.getInt("colonne"));
            gameMap.setPathimage(rs.getString("chemin_image"));
            return gameMap;
        }
    }

    public Map create(Map gameMap) {
        String sql = "INSERT INTO map (ligne, colonne, chemin_image) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, gameMap.getRows(), gameMap.getColumns(), gameMap.getPathimage());
        return gameMap;
    }

    public List<Map> getAllMaps() {
        String sql = "SELECT id_map, ligne, colonne, chemin_image FROM map";
        return jdbcTemplate.query(sql, new MapRowMapper());
    }

    public Map update(Map gameMap) {
        String sql = "UPDATE map SET ligne = ?, colonne = ?, chemin_image = ? WHERE id_map = ?";
        jdbcTemplate.update(sql, gameMap.getRows(), gameMap.getColumns(), gameMap.getPathimage(), gameMap.getId());
        return gameMap;
    }

    public boolean deleteById(Long id) {
        String sql = "DELETE FROM map WHERE id_map = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }
}
