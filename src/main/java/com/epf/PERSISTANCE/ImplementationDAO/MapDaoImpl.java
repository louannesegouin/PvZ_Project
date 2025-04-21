package com.epf.PERSISTANCE.ImplementationDAO;

import com.epf.CORE.models.Map;
import com.epf.PERSISTANCE.InterfaceDAO.MapDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class MapDaoImpl implements MapDao {
    private final JdbcTemplate jdbcTemplate;

    public MapDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(Map map) {
        String sql = "INSERT INTO map (ligne, colonne, chemin_image) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, 
            map.getLigne(), 
            map.getColonne(), 
            map.getChemin_image());
    }

    public List<Map> getAllMaps() {
        String sql = "SELECT * FROM map";
        RowMapper<Map> RowMapper = (rs, rowNum) -> new Map(
            rs.getInt("id_map"),
            rs.getInt("ligne"),
            rs.getInt("colonne"),
            rs.getString("chemin_image")
        );
        return jdbcTemplate.query(sql, RowMapper);
    }

    public void update(Map map) {
        String sql = "UPDATE map SET ligne = ?, colonne = ?, chemin_image = ? WHERE id_map = ?";
        jdbcTemplate.update(sql, 
            map.getLigne(), 
            map.getColonne(), 
            map.getChemin_image(), 
            map.getId_Map()
        );
    }

    public void delete(Map map) {
        String sql = "DELETE FROM map WHERE id_map = ?";
        jdbcTemplate.update(sql, map.getId_Map());
    }
}
