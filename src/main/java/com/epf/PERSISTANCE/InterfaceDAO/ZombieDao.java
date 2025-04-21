package com.epf.PERSISTANCE.InterfaceDAO;

import java.util.List;
import com.epf.CORE.models.Zombie;
import com.epf.CORE.models.Map; // Assurez-vous d'importer la classe Map si elle est utilisée

public interface ZombieDao {
    void create(Zombie zombie);
    List<Zombie> getAllZombies();
    List<Zombie> getZombiesFromMap(Map map);
    void update(Zombie zombie);
    void delete(Zombie zombie);
    void deleteZombieFromMap(Map map); // Supprimer un zombie d'une carte spécifique
}
