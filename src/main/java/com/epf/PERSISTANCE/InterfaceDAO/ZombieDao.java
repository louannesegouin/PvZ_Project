package com.epf.PERSISTANCE.InterfaceDAO;

import java.util.List;
import com.epf.CORE.models.Zombie;

public interface ZombieDao {
    void create(Zombie zombie);
    List<Zombie> getAllZombies();
    void update(Zombie zombie);
    void delete(Zombie zombie);
}
