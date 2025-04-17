package com.epf.PERSISTANCE.InterfaceDAO;

import java.util.List;
import java.util.Optional;

import com.epf.CORE.models.Zombie;

public interface ZombieDao {
    Zombie create(Zombie zombie);
    Optional<Zombie> findById(Long id);
    List<Zombie> findAll();
    Zombie update(Zombie zombie);
    boolean deleteById(Long id);
}
