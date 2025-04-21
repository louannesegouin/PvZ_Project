package com.epf.PERSISTANCE.ImplementationDAO;

import com.epf.CORE.models.Zombie;
import com.epf.PERSISTANCE.InterfaceDAO.ZombieDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ZombieDaoImpl implements ZombieDao {

    private final JdbcTemplate jdbcTemplate;

    public ZombieDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(Zombie zombie) {
        String sql = "INSERT INTO zombie (nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement, chemin_image, id_map) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, 
            zombie.getNom(), 
            zombie.getPoint_de_vie(), 
            zombie.getAttaque_par_seconde(), 
            zombie.getDegat_attaque(), 
            zombie.getVitesse_de_deplacement(), 
            zombie.getChemin_image(), 
            zombie.getId_map());
    }

    public List<Zombie> getAllZombies() {
        String sql = "SELECT * FROM zombie";
        RowMapper<Zombie> RowMapper = (rs, rowNew) -> new Zombie(
            rs.getInt("id_zombie"),
            rs.getString("nom"),
            rs.getInt("point_de_vie"),
            rs.getInt("attaque_par_seconde"),
            rs.getInt("degat_attaque"),
            rs.getInt("vitesse_de_deplacement"),
            rs.getString("chemin_image"),
            rs.getString("id_map")
        );
        return jdbcTemplate.query(sql, RowMapper);
    }

    public void update(Zombie zombie) {
        String sql = "UPDATE zombie SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, vitesse_de_deplacement = ?, chemin_image = ?, id_map = ? WHERE id_zombie = ?";
        jdbcTemplate.update(sql, 
            zombie.getNom(), 
            zombie.getPoint_de_vie(), 
            zombie.getAttaque_par_seconde(), 
            zombie.getDegat_attaque(), 
            zombie.getVitesse_de_deplacement(), 
            zombie.getChemin_image(), 
            zombie.getId_map(), 
            zombie.getId_zombie());
    }

    public void delete(Zombie zombie) {
        String sql = "DELETE FROM zombie WHERE id_zombie = ?";
        jdbcTemplate.update(sql, zombie.getId_zombie());
    }
}
