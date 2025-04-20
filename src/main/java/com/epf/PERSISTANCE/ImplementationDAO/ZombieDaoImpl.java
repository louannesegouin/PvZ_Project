package com.epf.PERSISTANCE.ImplementationDAO;

import com.epf.CORE.models.Zombie;
import com.epf.PERSISTANCE.InterfaceDAO.ZombieDao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ZombieDaoImpl implements ZombieDao {

    private final JdbcTemplate jdbcTemplate;

    public ZombieDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper pour transformer une ligne du ResultSet en objet Zombie
    private static final class ZombieRowMapper implements RowMapper<Zombie> {
        @Override
        public Zombie mapRow(ResultSet rs, int rowNum) throws SQLException {
            Zombie zombie = new Zombie();
            zombie.setId(rs.getLong("id_zombie"));
            zombie.setName(rs.getString("nom"));
            zombie.setHealth(rs.getInt("point_de_vie"));
            zombie.setDamagepersec(rs.getInt("attaque_par_seconde"));
            zombie.setDamage(rs.getInt("degat_attaque"));
            zombie.setSpeed(rs.getInt("vitesse_de_deplacement"));
            zombie.setPathimage(rs.getString("chemin_image"));
            zombie.setIdmap(rs.getString("id_map"));
            return zombie;
        }
    }

    public Zombie create(Zombie zombie) {
        String sql = "INSERT INTO zombie (nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement, chemin_image, id_map) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, zombie.getName(), zombie.getHealth(), zombie.getDamagepersec(), zombie.getDamage(), zombie.getSpeed(), zombie.getPathimage(), zombie.getIdmap());
        return zombie;
    }

    public List<Zombie> getAllZombies() {
        String sql = "SELECT * FROM zombie";
        return jdbcTemplate.query(sql, new ZombieRowMapper());
    }

    public Zombie update(Zombie zombie) {
        String sql = "UPDATE zombie SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, vitesse_de_deplacement = ?, chemin_image = ?, id_map = ? WHERE id = ?";
        jdbcTemplate.update(sql, zombie.getName(), zombie.getHealth(), zombie.getDamagepersec(), zombie.getDamage(), zombie.getSpeed(), zombie.getPathimage(), zombie.getIdmap(), zombie.getId());
        return zombie;
    }

    public boolean deleteById(Long id) {
        String sql = "DELETE FROM zombie WHERE id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }
}
