package com.epf.PERSISTANCE;

import com.epf.CORE.Zombie;
import java.util.List;
import java.util.Optional;

public interface ZombieDao {
    Zombie create(Zombie zombie);
    Optional<Zombie> findById(Long id);
    List<Zombie> findAll();
    Zombie update(Zombie zombie);
    boolean deleteById(Long id);
}
