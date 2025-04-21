package com.epf.PERSISTANCE.ImplementationDAO;

import com.epf.CORE.models.Plant;
import com.epf.PERSISTANCE.InterfaceDAO.PlantDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class PlantDaoImpl implements PlantDao {
    private final JdbcTemplate jdbcTemplate;

    public PlantDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(Plant plant) {
        String sql = "INSERT INTO plante (nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, 
            plant.getNom(),
            plant.getPoint_de_vie(),
            plant.getAttaque_par_seconde(),
            plant.getDegat_attaque(),
            plant.getCout(),
            plant.getSoleil_par_seconde(),
            plant.getEffet(),
            plant.getChemin_image()
        );
    }

    public List<Plant> getAllPlants() {
        String sql = "SELECT * FROM plante";
        RowMapper<Plant> RowMapper = (rs, rowNum) -> new Plant(
            rs.getInt("id_plante"),
            rs.getString("nom"),
            rs.getInt("point_de_vie"),
            rs.getInt("attaque_par_seconde"),
            rs.getInt("degat_attaque"),
            rs.getInt("cout"),
            rs.getInt("soleil_par_seconde"),
            rs.getString("effet"),
            rs.getString("chemin_image")
        );
        return jdbcTemplate.query(sql, RowMapper);
    }

    public void update(Plant plant) {
        String sql = "UPDATE plante SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, cout = ?, soleil_par_seconde = ?, effet = ?, chemin_image = ? WHERE id_plante = ?";
        jdbcTemplate.update(sql, 
            plant.getNom(),
            plant.getPoint_de_vie(),
            plant.getAttaque_par_seconde(),
            plant.getDegat_attaque(),
            plant.getCout(),
            plant.getSoleil_par_seconde(),
            plant.getEffet(),
            plant.getChemin_image(),
            plant.getId_plante()
        );
    }

    public void delete(Plant plant) {
        String sql = "DELETE FROM plante WHERE id_plante = ?";
        jdbcTemplate.update(sql, plant.getId_plante());
    }
}
