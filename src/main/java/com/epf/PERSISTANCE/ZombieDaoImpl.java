package com.epf.PERSISTANCE;

import com.epf.CORE.Zombie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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
            zombie.setId(rs.getLong("id"));
            zombie.setName(rs.getString("name"));
            zombie.setHealth(rs.getInt("health"));
            zombie.setDamagepersec(rs.getInt("damagepersec"));
            zombie.setDamage(rs.getInt("damage"));
            zombie.setSpeed(rs.getInt("speed"));
            zombie.setPathimage(rs.getString("pathimage"));
            zombie.setIdmap(rs.getString("idmap"));
            return zombie;
        }
    }

    @Override
    public Zombie create(Zombie zombie) {
        String sql = "INSERT INTO zombies (name, health, damagepersec, damage, speed, pathimage, idmap) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, zombie.getName(), zombie.getHealth(), zombie.getDamagepersec(), zombie.getDamage(), zombie.getSpeed(), zombie.getPathimage(), zombie.getIdmap());
        return zombie;
    }

    @Override
    public Optional<Zombie> findById(Long id) {
        String sql = "SELECT id, name, health, damagepersec, damage, speed, pathimage, idmap FROM zombies WHERE id = ?";
        try {
            Zombie zombie = jdbcTemplate.queryForObject(sql, new ZombieRowMapper(), id);
            return Optional.ofNullable(zombie);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Zombie> findAll() {
        String sql = "SELECT id, name, health, damagepersec, damage, speed, pathimage, idmap FROM zombies";
        return jdbcTemplate.query(sql, new ZombieRowMapper());
    }

    @Override
    public Zombie update(Zombie zombie) {
        String sql = "UPDATE zombies SET name = ?, health = ?, damagepersec = ?, damage = ?, speed = ?, pathimage = ?, idmap = ? WHERE id = ?";
        jdbcTemplate.update(sql, zombie.getName(), zombie.getHealth(), zombie.getDamagepersec(), zombie.getDamage(), zombie.getSpeed(), zombie.getPathimage(), zombie.getIdmap(), zombie.getId());
        return zombie;
    }

    @Override
    public boolean deleteById(Long id) {
        String sql = "DELETE FROM zombies WHERE id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }
}
