package com.epf.PERSISTANCE.InterfaceDAO;

import java.util.List;
import com.epf.CORE.models.Zombie;

public interface ZombieDao {
    Zombie create(Zombie zombie);
    List<Zombie> getAllZombies();
    Zombie update(Zombie zombie);
    boolean deleteById(Long id);
}
